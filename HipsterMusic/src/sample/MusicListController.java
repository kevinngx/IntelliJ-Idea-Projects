package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicListController {

    // Instantiate the database class
    Database database = new Database();

    @FXML
    TableView<Music> music_table;

    @FXML
    TableColumn<Music, String> column_album;

    @FXML
    TableColumn<Music, String> column_artist;

    @FXML
    TableColumn<Music, String> column_genre;

    @FXML
    TableColumn<Music, String> column_year;

    private ObservableList<Music> data;

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?
        System.out.println("INITIALIZED");

        try {
            getMusicList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        column_album.setCellValueFactory(new PropertyValueFactory<>("album"));
        column_artist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        column_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        column_year.setCellValueFactory(new PropertyValueFactory<>("year"));

        music_table.setItems(data);

    }

    //TODO: What do you need here?
    public void getMusicList() throws SQLException {
        data = FXCollections.observableArrayList();
//        ArrayList<Music> musicList = new ArrayList<Music>();
        String query = "SELECT * FROM music;";
        ResultSet rs = database.getResultSet(query);
        while (rs.next()) {
            System.out.println("Adding values...");
            data.add(new Music(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)

            ));
            System.out.println("Finished adding");
            System.out.println(data.size());
        }
    }

}
