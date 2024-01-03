import java.io.IOException;

/**
 * @author urey.liu
 * @description
 * @date 2023/11/7 3:30 下午
 */
public class ExecutePythonMethod {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("python","script.py");
        Process p = pb.start();
    }
}
