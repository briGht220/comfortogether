import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Class for running python file and getting result
 */
public class PythonRunner {
    /**
     * python file path
     */
    private String pythonFilePath = "";

    /**
     * Method for constructing PythonParser class
     * @param pythonFilePath python file path
     */
    public PythonRunner(String pythonFilePath) {
        this.pythonFilePath = pythonFilePath;
    }

    /**
     * Method for setting python file path
     * @param pythonFilePath python file path
     */
    public void setPythonFilePath(String pythonFilePath) {
        this.pythonFilePath = pythonFilePath;
    }

    /**
     * Method for getting python file path.
     * @return python file path
     * @see #pythonFilePath
     */
    public String getPythonFilePath() {
        return this.pythonFilePath;
    }

    /**
     * Method for connecting and running python file
     * @return BufferReader; result of python file
     * @throws Exception python file reading fail
     * @see #readPythonRunResult(Process)
     */
    public BufferedReader runPythonFile() throws Exception {
        // 1. connecting python file
        ProcessBuilder processBuilder = new ProcessBuilder("python", this.pythonFilePath);

        // 2. run python file
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // 3. waiting for python file running end
        int exitVal = process.waitFor();

        // 4. check running error
        if (exitVal != 0) {
            // on error
            System.out.println("Non-complete exit; " + exitVal);
            throw new Exception();
        } else {
            // not error
            System.out.println("Python run complete");
        }

        // return result of pyton file running
        return this.readPythonRunResult(process);
    }

    /**
     * Method for reading buffer for reading result of python file
     * @param process process of pyhon file running
     * @return BufferReader; result of python file
     */
    private BufferedReader readPythonRunResult(Process process) {
        return new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
    }

    public ArrayList<DetectedObject> getDetectedObject(BufferedReader bufferedReader) throws IOException {
        ArrayList<DetectedObject> arrayList = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] strings    = line.split(" ");
            String[] coordinate = strings[2].split(",");
            arrayList.add(
                    new DetectedObject(
                            strings[0],
                            Integer.parseInt(strings[1]),
                            Integer.parseInt(coordinate[0]),
                            Integer.parseInt(coordinate[1]),
                            Float.parseFloat(strings[3])
                    )
            );
        }

        return arrayList;
    }
}