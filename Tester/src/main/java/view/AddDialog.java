package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Entity;

public class AddDialog extends JDialog {
	
	static int  id;
	static String naziv;
	static private Map<String, String> simpleProperties = new HashMap<String, String>();
	static private Map<String, Entity> entityProperties = new HashMap<String, Entity>();
	
	public AddDialog() {
		JLabel idLbl = new JLabel("ID"),nazivLbl = new JLabel("Naziv"),atributiLbl =new JLabel("Pisite atribute po formatu naziv-vrednost");
		JTextField idTxt = new JTextField(),nazivTxt = new JTextField();
		JTextArea atributText = new JTextArea();
		JButton add = new JButton("Add"),ugnjezdeni = new JButton("Ugnjezdeni");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 id = Integer.parseInt(idTxt.getText());
				 naziv = nazivTxt.getText();
				 String[] str =  atributText.getText().split("-");
				 for(int i =0;i<str.length;i+=2) {
					 String res = str[i+1].substring(0, str[i+1].length());
					 simpleProperties.put(str[i], res);
				 }
				Entity ent = new Entity(id, naziv);
				ent.setSimpleProperties(simpleProperties);
				
			}
		});
	}
}
