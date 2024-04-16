package ciberton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    

    public static void main(String[] args) {
        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONArray jsonArray = new JSONArray(response.toString());

                List<User> userList = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String email = jsonObject.getString("email");

                    User user = new User(id, name, email);
                    userList.add(user);
                }

                System.out.println("Usuarios:");
                for (User user : userList) {
                    System.out.println(user);
                }
            } else {
                System.out.println("Error al obtener los datos." + responseCode);
            }
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Excepción en la solicitud: " + e.getMessage());
        }
    }
}

class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Email: " + email;
    }
}
