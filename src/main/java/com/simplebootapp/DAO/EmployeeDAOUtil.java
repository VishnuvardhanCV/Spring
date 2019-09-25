package com.simplebootapp.DAO;

import java.io.FileInputStream;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class EmployeeDAOUtil {

	public  Firestore getRepo()  {
		try {
			
		FileInputStream serviceAccount =
				  new FileInputStream("/Users/ggku3mac052/Downloads/fir-2d3e9-firebase-adminsdk-arvkp-71d4d339b7.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://fir-2d3e9.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
				Firestore db = FirestoreClient.getFirestore();
				return db;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
