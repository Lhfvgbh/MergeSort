package sort;

import exceptions.IncorrectKeyException;
import exceptions.SortingException;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Sorting {
    private boolean isNumber = false;
    private boolean isDescending = false;
    private List<String> files = new LinkedList<>();
    private String outputFileName;
    private String outputValue;

    public Sorting(String[] args) throws SortingException, IncorrectKeyException {
        boolean isKeyPresent = false;
        for (String arg : args) {
            if (arg.startsWith("-")) {
                switch (arg) {
                    case "-i":
                        isNumber = true;
                        isKeyPresent = true;
                        break;
                    case "-s":
                        isNumber = false;
                        isKeyPresent = true;
                        break;
                    case "-a":
                        isDescending = false;
                        break;
                    case "-d":
                        isDescending = true;
                        break;
                    default:
                        throw new IncorrectKeyException();
                }
            } else {
                files.add(arg);
            }
        }
        if (!isKeyPresent) {
            throw new IncorrectKeyException();
        }
        if (files.size() < 2) {
            throw new SortingException("Incorrect amount of files.");
        } else {
            outputFileName = files.get(0);
            files.remove(0);
        }
    }

    public boolean isNumber() {
        return isNumber;
    }

    public boolean isDescending() {
        return isDescending;
    }

    public List<String> getFiles() {
        return files;
    }

    public void sortFiles() throws SortingException {
        try (FileOutputStream fos = new FileOutputStream(new File(outputFileName))) {

            List<BufferedReader> readerStreams = new LinkedList<>();
            for (String file : files) {
                readerStreams.add(new BufferedReader(new FileReader(file)));
            }

            Integer[] valuesInt = new Integer[readerStreams.size()];
            String[] valuesString = new String[readerStreams.size()];

            String value;
            for (int i = 0; i < readerStreams.size(); i++) {
                if ((value = readerStreams.get(i).readLine()) != null) {
                    if (isNumber) {
                        valuesInt[i] = Integer.parseInt(value);
                    } else {
                        valuesString[i] = value;
                    }
                } else {
                    readerStreams.get(i).close();
                    readerStreams.remove(i);
                    if (isNumber) {
                        valuesInt = removeFromArrayByIndex(Integer.class, valuesInt, i);
                    } else {
                        valuesString = removeFromArrayByIndex(String.class, valuesString, i);
                    }
                    i--;
                }
            }

            while (readerStreams.size() > 0) {
                int thread;
                if (isNumber) {
                    if (isDescending) {
                        thread = sortNumDesc(valuesInt);
                    } else {
                        thread = sortNum(valuesInt);
                    }
                } else {
                    if (isDescending) {
                        thread = sortStringDesc(valuesString);
                    } else {
                        thread = sortString(valuesString);
                    }
                }
                fos.write(outputValue.getBytes());
                fos.write(System.getProperty("line.separator").getBytes());
                fos.flush();

                if ((value = readerStreams.get(thread).readLine()) != null) {
                    if (isNumber) {
                        valuesInt[thread] = Integer.parseInt(value);
                    } else {
                        valuesString[thread] = value;
                    }
                } else {
                    readerStreams.get(thread).close();
                    readerStreams.remove(thread);
                    if (isNumber) {
                        valuesInt = removeFromArrayByIndex(Integer.class, valuesInt, thread);
                    } else {
                        valuesString = removeFromArrayByIndex(String.class, valuesString, thread);
                    }
                }
            }

        } catch (NumberFormatException ex) {
            throw new SortingException("Incorrect file format. Check is files are numeric or alphabetic");
        } catch (IOException e) {
            throw new SortingException("Error with files.");
        }
    }

    private <E> E[] removeFromArrayByIndex(Class<E> clazz, E[] array, int index) {
        if (array == null || index < 0 || index >= array.length)
            return array;
        E[] newArray = (E[]) Array.newInstance(clazz, array.length - 1);

        for (int i = 0, k = 0; i < array.length; i++) {
            if (i != index)
                newArray[k++] = array[i];
        }
        return newArray;
    }


    private int sortStringDesc(String[] values) {
        String max = values[0];
        int index = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[index].compareToIgnoreCase(values[i]) < 0) {
                max = values[i];
                index = i;
            }
        }
        this.outputValue = max;
        return index;
    }

    private int sortNumDesc(Integer[] values) {
        int max = values[0];
        int index = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                index = i;
            }
        }
        this.outputValue = String.valueOf(max);
        return index;
    }

    private int sortNum(Integer[] values) {
        int min = values[0];
        int index = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
                index = i;
            }
        }
        this.outputValue = String.valueOf(min);
        return index;
    }

    private int sortString(String[] values) {
        String min = values[0];
        int index = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[index].compareToIgnoreCase(values[i]) > 0) {
                min = values[i];
                index = i;
            }
        }
        this.outputValue = min;
        return index;
    }

}
