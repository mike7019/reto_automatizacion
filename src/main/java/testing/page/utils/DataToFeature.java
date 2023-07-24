package testing.page.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.apache.commons.csv.CSVFormat.Predefined.Excel;

public class DataToFeature {
    public DataToFeature() {
    }

    private static List<String> setExcelDataToFeature2(File featureFile) throws InvalidFormatException, IOException {
        List<String> fileData = new ArrayList();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"));

        try {
            List<Map<String, String>> excelData = null;
            boolean foundHashTag = false;
            boolean featureData = false;
            boolean esUnRango = false;
            boolean esMultiple = false;
            boolean esRangoDefinido = false;

            label113:
            while(true) {
                while(true) {
                    String data;
                    if ((data = buffReader.readLine()) == null) {
                        break label113;
                    }

                    String[] dataVector = null;
                    String[] dataVectorRango = null;
                    String sheetName = null;
                    String excelFilePath = null;
                    int filaSeleccionada = 0;
                    int pos = 0;
                    if (data.trim().contains("##@externaldata")) {
                        dataVector = data.trim().split("@");
                        excelFilePath = dataVector[2];
                        sheetName = dataVector[3];
                        if (dataVector.length == 4) {
                            esUnRango = true;
                        }

                        if (dataVector.length == 5) {
                            if (dataVector[4].toString().contains("-")) {
                                dataVectorRango = dataVector[4].trim().split("-");
                                esRangoDefinido = true;
                                filaSeleccionada = Integer.parseInt(dataVectorRango[pos]) - 1;
                            } else if (dataVector[4].toString().contains(",")) {
                                dataVectorRango = dataVector[4].trim().split(",");
                                esUnRango = true;
                                esMultiple = true;
                                filaSeleccionada = Integer.parseInt(dataVectorRango[pos]) - 1;
                            } else {
                                filaSeleccionada = Integer.parseInt(dataVector[4]) - 1;
                            }
                        }

                        foundHashTag = true;
                        fileData.add(data);
                    }

                    if (foundHashTag) {
                        excelData = (new Excel()).getData(excelFilePath, sheetName);

                        for(int rowNumber = filaSeleccionada; rowNumber < excelData.size() - 1; ++rowNumber) {
                            String cellData = "";
                            Iterator var18 = ((Map)excelData.get(rowNumber)).entrySet().iterator();

                            while(var18.hasNext()) {
                                Map.Entry<String, String> mapData = (Map.Entry)var18.next();
                                if (dataVectorRango == null) {
                                    cellData = cellData + "   |" + (String)mapData.getValue();
                                } else if (esRangoDefinido) {
                                    if (rowNumber < Integer.parseInt(dataVectorRango[1])) {
                                        cellData = cellData + "   |" + (String)mapData.getValue();
                                    }
                                } else if (rowNumber + 1 == Integer.parseInt(dataVectorRango[pos]) && esUnRango) {
                                    cellData = cellData + "   |" + (String)mapData.getValue();
                                }
                            }

                            fileData.add(cellData + "|");
                            if (!esUnRango && !esRangoDefinido) {
                                rowNumber = excelData.size();
                            }

                            if (esMultiple) {
                                if (pos + 1 < dataVectorRango.length) {
                                    filaSeleccionada = Integer.parseInt(dataVectorRango[pos + 1]) - 1;
                                    rowNumber = filaSeleccionada - 1;
                                    ++pos;
                                } else {
                                    rowNumber = excelData.size() - 1;
                                }
                            }

                            if (esRangoDefinido) {
                                if (null == dataVectorRango) {
                                    throw new IllegalStateException("vector is null");
                                }

                                if (rowNumber + 1 == Integer.parseInt(dataVectorRango[1])) {
                                    rowNumber = excelData.size() - 1;
                                    ++pos;
                                } else {
                                    ++pos;
                                }
                            }
                        }

                        foundHashTag = false;
                        featureData = true;
                    } else if (!data.startsWith("|") && !data.endsWith("|")) {
                        featureData = false;
                        fileData.add(data);
                    } else if (!featureData) {
                        fileData.add(data);
                    }
                }
            }
        } catch (Throwable var21) {
            try {
                buffReader.close();
            } catch (Throwable var20) {
                var21.addSuppressed(var20);
            }

            throw var21;
        }

        buffReader.close();
        return fileData;
    }

    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList();
        if (folder.getName().endsWith(".feature")) {
            featureFiles.add(folder);
        } else {
            File[] var2 = folder.listFiles();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                File fileEntry = var2[var4];
                if (fileEntry.isDirectory()) {
                    featureFiles.addAll(listOfFeatureFiles(fileEntry));
                } else if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                    featureFiles.add(fileEntry);
                }
            }
        }

        return featureFiles;
    }

    public static void overrideFeatureFiles(String featuresDirectoryPath) throws IOException, InvalidFormatException {
        List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));

        BufferedWriter writer;
        for(Iterator var2 = listOfFeatureFiles.iterator(); var2.hasNext(); writer.close()) {
            File featureFile = (File)var2.next();
            List<String> featureWithExcelData = setExcelDataToFeature2(featureFile);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));

            try {
                Iterator var6 = featureWithExcelData.iterator();

                while(var6.hasNext()) {
                    String string = (String)var6.next();
                    writer.write(string);
                    writer.write("\n");
                }
            } catch (Throwable var9) {
                try {
                    writer.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }
        }

    }
}
