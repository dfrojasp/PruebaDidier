package Utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
public class DataToFeature {
    private static List<String> setExcelDataToFeature(File featureFile)

            throws InvalidFormatException, IOException {
        List<String> fileData = new ArrayList<String>();
        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"))) {
            String data;
            List<Map<String, String>> excelData = null;
            boolean foundHashTag = false;
            boolean featureData = false;
            while ((data = buffReader.readLine()) != null) {
                String sheetName = null;
                String excelFilePath = null;
                if (data.trim().contains("##@externaldata")) {
                    excelFilePath = data.substring(StringUtils.ordinalIndexOf(data, "@", 2) + 1, data.lastIndexOf("@"));
                    sheetName = data.substring(data.lastIndexOf("@") + 1, data.length());
                    foundHashTag = true;
                    fileData.add(data);
                }
                if (foundHashTag) {
                    excelData = new LectorExcel().getData(excelFilePath, sheetName);
//	                    String columnHeader = "";

//	                    for (Entry<String, String> map : excelData.get(0).entrySet()) {
//	                        columnHeader = columnHeader + "|" + map.getKey();
//	                    }
//
//	                    fileData.add(columnHeader + "|");

                    for (int rowNumber = 0; rowNumber < excelData.size() - 1; rowNumber++) {
                        String cellData = "";
                        for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
                            cellData = cellData + "\"|\"" + mapData.getValue();
                        }
                        cellData = cellData.substring(1, cellData.length());
                        cellData += "\"|";
                        fileData.add(cellData);
                    }
                    foundHashTag = false;
                    featureData = true;
                    continue;
                }
                if (data.startsWith("|") || data.endsWith("|")) {
                    if (featureData) {
                        continue;
                    } else {
                        fileData.add(data);
                        continue;
                    }
                } else {
                    featureData = false;
                }
                fileData.add(data);
            }
        }
        return fileData;
    }
    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList<File>();
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                featureFiles.addAll(listOfFeatureFiles(fileEntry));
            } else {
                if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                    featureFiles.add(fileEntry);
                }
            }
        }
        return featureFiles;
    }
    public static void overrideFeatureFiles(String featuresDirectoryPath)
    // public void overrideFeatureFiles(String featuresDirectoryPath)
            throws IOException, InvalidFormatException {
        List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
        for (File featureFile : listOfFeatureFiles) {
            List<String> featureWithExcelData = setExcelDataToFeature(featureFile);
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));) {
                for (String string : featureWithExcelData) {
                    writer.write(string);
                    writer.write("\n");
                }
            }
        }
    }
}
