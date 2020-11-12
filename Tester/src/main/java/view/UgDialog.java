package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import impl.ImportExportJSON;
import model.Entity;
import type.TypeFile;

public class UgDialog extends JDialog {

	public UgDialog(Entity ent) {
		
		JLabel nazivLbl = new JLabel("Naziv"),atributiLbl =new JLabel("Pisite atribute po formatu naziv-vrednost-");
		JTextField nazivTxt = new JTextField();
		JTextArea atributText = new JTextArea();
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				 String naziv = nazivTxt.getText();
				 String[] str =  atributText.getText().split("-");
				 Map<String, String> simpleProperties = new HashMap<String, String>();
				 for(int i =0;i<str.length;i+=2) {
					 //String res = str[i+1].substring(0, str[i+1].length());
					 simpleProperties.put(str[i], str[i+1]);
				 }
				 Entity en = new Entity(ent.getId(), naziv);
				 en.setSimpleProperties(simpleProperties);
				 ent.addEntityProperties(naziv, en);
				 MainView.getInstance().getList().add(ent);
					TypeFile tf= MainView.getInstance().getTypeF();
					if(tf==TypeFile.JSON) {
						ImportExportJSON ie = new ImportExportJSON();
						ie.exportObjectToFile(MainView.getInstance().getList(), MainView.getInstance().getFilepath());
					}
					else if(tf==TypeFile.YML) {
						
					}
					else {
						
					}
					MainView.getInstance().getListModel().addElement(ent);
					dispose();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		add(nazivLbl);
		add(nazivTxt);
		add(atributiLbl);
		add(atributText);
		add(add);
		setLayout(new GridLayout(3,2));
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
}
