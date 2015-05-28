package br.com.ericogr.tfs.teste;

import com.microsoft.tfs.core.TFSTeamProjectCollection;
import com.microsoft.tfs.core.clients.framework.configuration.entities.TeamProjectEntity;
import com.microsoft.tfs.core.httpclient.Credentials;
import com.microsoft.tfs.core.httpclient.UsernamePasswordCredentials;
import com.microsoft.tfs.core.util.URIUtils;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    @FXML
    private TextField campoEndereco;
    
    @FXML
    private TextField campoUsuario;
    
    @FXML
    private TextField campoSenha;
    
    @FXML
    private ListView<String> listaDeProjetos;
    
    @FXML
    private void handleBotaoFechar(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void handleBotaoAtualizar(ActionEvent event) {
        try {
            setItens(listarProjetos());
        } catch (Exception ex) {
            this.listaDeProjetos.setItems(FXCollections.observableArrayList(new String[] {"Erro: " + ex.getMessage()}));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    private void setItens(Set<String> itens) {
        this.listaDeProjetos.setItems(FXCollections.observableArrayList(itens));
    }
    
    private Set<String> listarProjetos() {
        Credentials credentials = new UsernamePasswordCredentials(this.campoUsuario.getText(), this.campoSenha.getText());
        TFSTeamProjectCollection tpc = new TFSTeamProjectCollection(URIUtils.newURI(this.campoEndereco.getText()), credentials);
        
        Set<String> projetos = new HashSet<>();
        for (TeamProjectEntity tp : tpc.getTeamProjectCollectionEntity(true).getTeamProjects()) {
            projetos.add(tp.getProjectName());
        }
        
        return projetos;
    }

    private void limparListaDeProjetos() {
        this.listaDeProjetos.getItems().clear();
    }
}
