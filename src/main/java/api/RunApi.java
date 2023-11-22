package api;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.BufferedReader;

public class RunApi {
	
	public static void main(String[]args) {
		RunApi runApi = new RunApi();
        
        runApi.postCommentSuccess("all goods!");
	}

    public void postCommentSuccess(String message) {
        try {
            // URL for the Jira API
            URL url = new URL("https://testjiracommentjava.atlassian.net/rest/api/2/issue/TES-3/comment");
            System.out.println("URL: " + url.toString());

            // Open a connection (POST)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // Basic Authentication
            String username = "kurt.bradley.jocson@gmail.com"; // Replace with your Jira email
            String apiToken = "ATATT3xFfGF0r6vYuj8St5tuB_ybod4MOJFUXfQaTfrJVqNKeiEQe0iNirFD11f_NBjyEdAP5Lwb4JVTP9pFdHhLYYGGDDLyOG70dmhR6WK8eAmLTF4BkZjAkeMWkYrLIefnHgTIos90QA-bw5M2Gh6R2ylqK-AbKu5T3ls-F38UVqIFugH4b4E=201E2E77"; // Replace with your API token
            String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + apiToken).getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            System.out.println("Authorization: Basic " + encodedCredentials);

            connection.setDoOutput(true);

            // JSON String to post
            String jsonInputString = "{\"body\": \""+message+"\"}";
            System.out.println("JSON Body: " + jsonInputString);

            // Output stream to write data
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read the response
            int responseCode = connection.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            // Read the response content
            InputStream responseStream = responseCode < HttpURLConnection.HTTP_BAD_REQUEST ? connection.getInputStream() : connection.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            String line;
            StringBuilder responseContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
                responseContent.append("\n");
            }
            reader.close();

            // Print the response content
            System.out.println("Response Content :: " + responseContent.toString());

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void postCommentFailed() {
        try {
            // URL for the Jira API
            URL url = new URL("https://testjiracommentjava.atlassian.net/rest/api/2/issue/TES-3/comment");
            System.out.println("URL: " + url.toString());

            // Open a connection (POST)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // Basic Authentication
            String username = "kurt.bradley.jocson@gmail.com"; // Replace with your Jira email
            String apiToken = "ATATT3xFfGF0r6vYuj8St5tuB_ybod4MOJFUXfQaTfrJVqNKeiEQe0iNirFD11f_NBjyEdAP5Lwb4JVTP9pFdHhLYYGGDDLyOG70dmhR6WK8eAmLTF4BkZjAkeMWkYrLIefnHgTIos90QA-bw5M2Gh6R2ylqK-AbKu5T3ls-F38UVqIFugH4b4E=201E2E77"; // Replace with your API token
            String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + apiToken).getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            System.out.println("Authorization: Basic " + encodedCredentials);

            connection.setDoOutput(true);

            // JSON String to post
            String jsonInputString = "{\"body\": \"many bad!!!\"}";
            System.out.println("JSON Body: " + jsonInputString);

            // Output stream to write data
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read the response
            int responseCode = connection.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            // Read the response content
            InputStream responseStream = responseCode < HttpURLConnection.HTTP_BAD_REQUEST ? connection.getInputStream() : connection.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            String line;
            StringBuilder responseContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
                responseContent.append("\n");
            }
            reader.close();

            // Print the response content
            System.out.println("Response Content :: " + responseContent.toString());

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
