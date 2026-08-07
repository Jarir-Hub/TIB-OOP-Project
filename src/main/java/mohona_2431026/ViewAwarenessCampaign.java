package mohona_2431026;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Locale;

public class ViewAwarenessCampaign
{
    @javafx.fxml.FXML
    private TextField searchCampaignTextField;
    @javafx.fxml.FXML
    private TableColumn<awarenessmodel,String> campaignTitleColumn;
    @javafx.fxml.FXML
    private TableColumn<awarenessmodel,String> campaignTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<awarenessmodel,Integer> campaignIdColumn;
    @javafx.fxml.FXML
    private TableView<awarenessmodel> campaignTableView;
    @javafx.fxml.FXML
    private TableColumn<awarenessmodel,String>venueColumn;
    @javafx.fxml.FXML
    private TableColumn<awarenessmodel,String> campaignDateColumn;
    @javafx.fxml.FXML
    private TextField campaignDetailsTextArea;

    @javafx.fxml.FXML
    public void initialize() {
        campaignIdColumn.setCellValueFactory(new PropertyValueFactory<>("campaignId"));
        campaignTitleColumn.setCellValueFactory(new PropertyValueFactory<>("campaignTitle"));
        campaignTypeColumn.setCellValueFactory(new PropertyValueFactory<>("campaignTYPE"));
        campaignDateColumn.setCellValueFactory(new PropertyValueFactory<>("campaignDate"));
        venueColumn.setCellValueFactory(new PropertyValueFactory<>("venue"));

        localCampaigns();

        campaignTableView.getSelectionModel().selectedItemProperty().addListener((obs,oldvalue,newValue)->{
            if(newValue!=null){

                campaignDetailsTextArea.setText(
                        "campaign Details : " + newValue.getCampaignDetails()
                        + "\norganizer : "   + newValue.getOrganizer()

                );
            }
        } );
    }

    private void localCampaigns() {

        campaignList.clear();


        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("awarenesscampaign.bin"));

            while(true){

                awarenessmodel a = (awarenessmodel)  ois.readObject();
                campaignList.add(a)


            }

        }catch (EOFException e){

        }catch(Exception e){
            e.printStackTrace();
        }

        campaignTableView.setItems(campaignList);

        if(campaignList.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.INFORMATION)
            alert.setHeaderText(null);
            alert.setContentText("no campaign Available");
            alert.showAndWait()

        }

    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {

        string title = searchCampaignTextField.getText().trim()
        observableList<awarenessmodel>searchList = FXCollections.observableArrayList();
         for(awarenessmodel a : CampaignList){
             if(a.getCampaignTitle().toLowerCase(Locale.ROOT).contains(title.tolowercase())){
                 searchList.add(a):

             }
         }
        if(searchList.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No Campaign Found");
            alert.showAndWait();

        }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {

            campaignTableView.setItems(searchList);
        }
    }



    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}