package api;
/*
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.BufferedReader;*/

import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.ContentType;

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;

import java.io.File;
import java.io.IOException;

import org.apache.http.entity.StringEntity;

public class RunApi {
	
	public static void main(String[]args) throws ClientProtocolException, IOException {
		RunApi runApi = new RunApi();
        
		//change path parameter
        runApi.postCommentSuccess("all goods!","C:/Users/OneDrive/Desktop/report.html");
	}
	
	public void postCommentSuccess(String message, String pathToFile) throws ClientProtocolException, IOException {
		
		//TODO: Config
		//Example: TES-3
        String issueKey = "";
        
        //change yourprojectdomain 
        String jiraUrl = "https://yourprojectdomain.atlassian.net/rest/api/2/issue/" + issueKey + "/attachments";
        
        //Argument from paramaters
        String filePath = pathToFile;
        
        //username / email in jire
        String user = "";
        
        //toke generated from atlassian account settings > security > Create and manage API tokens
        String token = ""; // Generate API token from JIRA

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(jiraUrl);
        post.setHeader("X-Atlassian-Token", "no-check");
        post.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((user + ":" + token).getBytes()));

        File fileToUpload = new File(filePath);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addBinaryBody("file", fileToUpload, ContentType.DEFAULT_BINARY, fileToUpload.getName());

        post.setEntity(builder.build());

        HttpResponse response = client.execute(post);
        System.out.println(response);
        
        //change yourprojectdomain
        String commentUrl = "https://yourprojectdomain.atlassian.net/rest/api/2/issue/TES-3/comment";
        
        // Step 2: Add a Comment Referencing the Attachment
        HttpPost postComment = new HttpPost(commentUrl);
        postComment.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((user + ":" + token).getBytes()));
        postComment.setHeader("Content-Type", "application/json");
        
        String jsonComment = "{\"body\": \""+message+" \nSee attached file: [^file.html]\"}";
        StringEntity commentEntity = new StringEntity(jsonComment);
        postComment.setEntity(commentEntity);

        HttpResponse commentResponse = client.execute(postComment);
        System.out.println(commentResponse);
	}
	

   


}
