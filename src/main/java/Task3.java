import java.io.*;
import java.net.Socket;

/**
 * Solution for Task 3: Fetching HTML content using raw Sockets.
 */
public class Task3 {

    /**
     * Retrieves the HTML content from www.google.com and saves it to a file,
     * stripping out the HTTP response headers.
     * 
     * @param outputFilePath The path of the file where the HTML should be saved.
     * @throws IOException If a network or file I/O error occurs.
     */
    public static void fetchGoogleHomepage(String outputFilePath) throws IOException {
        String host = "www.google.com";
        int port = 80; // Default HTTP port

        // try-with-resources ensures all streams and sockets are automatically closed
        try (Socket socket = new Socket(host, port);
             PrintWriter requestWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader responseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             FileWriter fileWriter = new FileWriter(outputFilePath)) {

            // 1. Construct and send the raw HTTP 1.1 GET request
            requestWriter.print("GET / HTTP/1.1\r\n");
            requestWriter.print("Host: " + host + "\r\n");
            requestWriter.print("Connection: close\r\n"); // Tells the server to close the connection after sending
            requestWriter.print("\r\n"); // An empty line indicates the end of the request headers
            requestWriter.flush();

            // 2. Read the response and extract only the HTML (ignoring headers)
            String line;
            boolean isBody = false;

            while ((line = responseReader.readLine()) != null) {
                if (isBody) {
                    // We are past the headers, write the HTML content to the file
                    fileWriter.write(line + System.lineSeparator());
                } else if (line.isEmpty()) {
                    // According to HTTP spec, an empty line separates headers from the body
                    isBody = true;
                }
            }
        }
    }
}