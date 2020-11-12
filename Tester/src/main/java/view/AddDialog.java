package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import impl.ImportExportJSON;
import model.Entity;
import type.TypeFile;

public class AddDialog extends JDialog {
	
	
	
	public AddDialog() {
		boolean flag = true;
		JLabel idLbl = new JLabel("ID"),nazivLbl = new JLabel("Naziv"),atributiLbl =new JLabel("Pisite atribute po formatu naziv-vrednost-");
		JTextField idTxt = new JTextField(),nazivTxt = new JTextField();
		JTextArea atributText = new JTextArea();
		JButton add = new JButton("Add"),ugnjezdeni = new JButton("Ugnjezdeni");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=0;
				try {
					 Map<String, String> simpleProperties = new HashMap<String, String>();
					 if(idTxt.getText().isEmpty()) {
						boolean i = true;
						while(i) {
							Random rand = new Random();
							int r = rand.nextInt(101);
							boolean j = false;
							for (Entity en : MainView.getInstance().getList()) {
								if(en.getId()==r) {
									j = true;
									break;
								}
							}
							if(j) {
								continue;
							}
							else {
								i = false;
								id = r;
							}
						}
					 }
					 else
						 id = Integer.parseInt(idTxt.getText());
					 String naziv = nazivTxt.getText();
					 String[] str =  atributText.getText().split("-");
					 for(int i =0;i<str.length;i+=2) {
						 //String res = str[i+1].substring(0, str[i+1].length());
						 simpleProperties.put(str[i], str[i+1]);
					 }
					 for (Entity en : MainView.getInstance().getList()) {
						if(en.getId()==id) {
							JDialog warning = new JDialog();
							JLabel idTaken = new JLabel("ID VEC ISKORISCEN");
							warning.add(idTaken);
							warning.setSize(new Dimension(200, 200));
							warning.setLocationRelativeTo(null);
							warning.setVisible(true);
							return;
						}
					}
					Entity ent = new Entity(id, naziv);
					ent.setSimpleProperties(simpleProperties);
					if(MainView.getInstance().getList().size()==100) {
						StringBuilder sb = new  StringBuilder(MainView.getInstance().getFilepath());
						sb.append("next");
						File newFile = new File(sb.toString());
						newFile.createNewFile();
						MainView.getInstance().setFilepath(sb.toString());
						MainView.getInstance().getList().clear();
						MainView.getInstance().getListModel().clear();
					}
					MainView.getInstance().getList().add(ent);
					TypeFile tf= MainView.getInstance().getTypeF();
					if(tf==TypeFile.JSON) {
						ImportExportJSON ie = new ImportExportJSON();
						ie.exportObjectToFile(MainView.getInstance().getList(), MainView.getInstance().getFilepath());
					}
					else if(tf==TypeFile.YML) {
						//ImportExportYaml ie = new ImportExportYaml();
					}
					else {
						
					}
					MainView.getInstance().getListModel().addElement(ent);
					dispose();
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		ugnjezdeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=0;
				try {
					 //Map<String, String> simpleProperties = new HashMap<String, String>();
					 if(idTxt.getText().isEmpty()) {
						boolean i = true;
						while(i) {
							Random rand = new Random();
							int r = rand.nextInt(100);
							boolean j = false;
							for (Entity en : MainView.getInstance().getList()) {
								if(en.getId()==r) {
									j = true;
									break;
								}
							}
							if(j) {
								continue;
							}
							else {
								i = false;
								id = r;
							}
						}
					 }
					 else
						 id = Integer.parseInt(idTxt.getText());
					 String naziv = nazivTxt.getText();
					 String[] str =  atributText.getText().split("-");
					 Map<String, String> simpleProperties = new HashMap<String, String>();
					 for(int i =0;i<str.length;i+=2) {
						 if(str[i].contains("\n"))
							  str[i] = str[i].substring(1);
						 simpleProperties.put(str[i], str[i+1]);
					 }
					 for (Entity en : MainView.getInstance().getList()) {
						if(en.getId()==id) {
							JDialog warning = new JDialog();
							JLabel idTaken = new JLabel("ID VEC ISKORISCEN");
							warning.add(idTaken);
							warning.setSize(new Dimension(200, 200));
							warning.setLocationRelativeTo(null);
							warning.setVisible(true);
							return;
						}
					}
					Entity enn = new Entity(id, naziv);
					enn.setSimpleProperties(simpleProperties);
					UgDialog ug = new UgDialog(enn);
					dispose();
					
					
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
			}
		});
		add(idLbl);
		add(idTxt);
		add(nazivLbl);
		add(nazivTxt);
		add(atributiLbl);
		add(atributText);
		add(add);
		add(ugnjezdeni);
		setLayout(new GridLayout(4,2));
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
