package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Entity;

public class SearchDialog extends JDialog {
	private JTextField atributeTxt;
	private JComboBox<String> comboBoxOperation,sortBox,parSorttxt,ugBox;
	private JLabel colName;
	private JLabel operationName;
	private JLabel value,parSort,orderSort,ugPar,ugValue;
	private JButton next;
	private JTextField valueTxt,ugPartxt,ugvaluetxt;
	private JButton done;
	private List<Entity> result;
	private List<Entity> toDel;
	public SearchDialog() throws Exception {
		result = new ArrayList<Entity>();
		result.addAll(MainView.getInstance().getList());
		toDel = new ArrayList<Entity>();
		toDel.addAll(result);
		ugPar = new JLabel("Ug parametar");
		ugValue = new JLabel("Ug vrednost");
		ugPartxt = new JTextField();
		ugvaluetxt = new  JTextField();
		parSort = new JLabel("Parameter sort");
		orderSort = new JLabel("Order of sort");
		atributeTxt = new JTextField();
		colName=new JLabel("Atribute name");
		parSorttxt = new JComboBox<String>();
		parSorttxt.addItem("id");
		parSorttxt.addItem("naziv");
		sortBox = new JComboBox<String>();
		sortBox.addItem("Ascending");
		sortBox.addItem("Descending");
		operationName=new JLabel("Operation");
		value = new JLabel("Value");
		valueTxt = new JTextField();
		next = new JButton("Next");
		comboBoxOperation = new JComboBox<String>();
		done = new JButton("Done");
		
		comboBoxOperation.addItem("Pronadji sve sto pocinje sa:");
		comboBoxOperation.addItem("Pronadji sve sto sadrzi");
		comboBoxOperation.addItem("Pronadji sve sto ima ovaj atribut");
		comboBoxOperation.addItem("Pronadji sve sto je jednako");
		
		ugBox = new  JComboBox<String>();
		ugBox.addItem("Pronadji sve sto pocinje sa:");
		ugBox.addItem("Pronadji sve sto sadrzi");
		ugBox.addItem("Pronadji sve sto ima ovaj atribut");
		ugBox.addItem("Pronadji sve sto je jednako");
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String atribute = atributeTxt.getText();
				String value = valueTxt.getText();
				for (Entity entity : toDel) {
					boolean found = false;
					if(atribute.equals("id") && comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto je jednako")) {
						if(entity.getId() == (Integer.parseInt(value))) {
							found = true;
							continue;
						}
					}
					else if(atribute.equals("naziv")) {
							if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto pocinje sa:")) {
								if(entity.getNaziv().startsWith(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto sadrzi")) {
								if(entity.getNaziv().contains(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto je jednako")) {
								if(entity.getNaziv().equals(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto ima ovaj atribut")) {
								found = true;
								continue;
							}
						
					}
					else {
						Iterator it = entity.getSimpleProperties().entrySet().iterator();
					    while (it.hasNext()) {
					        Map.Entry pair = (Map.Entry)it.next();
					        if(pair.getKey().equals(atribute))
					        	continue;
					        if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto pocinje sa:")) {
								if(pair.getValue().toString().startsWith(value)) {
									found = true;
									continue;
								}
					        }
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto sadrzi")) {
								if(pair.getValue().toString().contains(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto je jednako")) {
								if(pair.getValue().toString().equals(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto ima ovaj atribut")) {
								found = true;
								continue;
							}
					    }
					}
					if(!found) {
						result.remove(entity);
						
					}
				}
				toDel = new ArrayList<Entity>();
				toDel.addAll(result);
			}
		});
		
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String atribute = atributeTxt.getText();
				String value = valueTxt.getText();
				for (Entity entity : toDel) {
					boolean found = false;
					if(atribute.equals("id") && comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto je jednako")) {
						if(entity.getId() == (Integer.parseInt(value))) {
							found = true;
							continue;
						}
					}
					else if(atribute.equals("naziv")) {
							if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto pocinje sa:")) {
								if(entity.getNaziv().startsWith(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto sadrzi")) {
								if(entity.getNaziv().contains(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto je jednako")) {
								if(entity.getNaziv().equals(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto ima ovaj atribut")) {
								found = true;
								continue;
							}
						
					}
					else {
						Iterator it = entity.getSimpleProperties().entrySet().iterator();
					    while (it.hasNext()) {
					        Map.Entry pair = (Map.Entry)it.next();
					        if(!pair.getKey().toString().equals(atribute))
					        	continue;
					        if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto pocinje sa:")) {
								if(pair.getValue().toString().startsWith(value)) {
									found = true;
									continue;
								}
					        }
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto sadrzi")) {
								if(pair.getValue().toString().contains(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto je jednako")) {
								if(pair.getValue().toString().equals(value)) {
									found = true;
									continue;
								}
							}
							else if(comboBoxOperation.getSelectedItem().toString().equals("Pronadji sve sto ima ovaj atribut")) {
								found = true;
								continue;
							}
					    }
					}
					if(!found) {
						result.remove(entity);
					}
				}
				String par = parSorttxt.getSelectedItem().toString();
				 if(comboBoxOperation.getSelectedItem().toString().equals("Ascending")) {
						result.sort(new Comparator<Entity>() {

							@Override
							public int compare(Entity o1, Entity o2) {
								if(par.equals("id")) {
									Integer i1 = new Integer(o1.getId());
									Integer i2 = new Integer(o2.getId());
									return i1.compareTo(i2);
								}
								else  {
									return o1.getNaziv().compareTo(o2.getNaziv());
								}
							}
						});
			     }
				else if(comboBoxOperation.getSelectedItem().toString().equals("Descending")) {
					result.sort(new Comparator<Entity>() {

						@Override
						public int compare(Entity o1, Entity o2) {
							if(par.equals("id")) {
								Integer i1 = new Integer(o1.getId());
								Integer i2 = new Integer(o2.getId());
								return i2.compareTo(i1);
							}
							else  {
								return o2.getNaziv().compareTo(o1.getNaziv());
							}
						}
					});
					}
				
				dispose();
				JDialog resultDialog = new JDialog();
				resultDialog.setSize(new Dimension(1700,300));
				resultDialog.setLocationRelativeTo(null);
				DefaultListModel<Entity> listModel = new DefaultListModel<Entity>();
			    listModel.addAll(result);
			    JList<Entity> jList = new JList<Entity>(listModel);
			    JScrollPane scr = new JScrollPane(jList);
			    resultDialog.add(scr,BorderLayout.CENTER);
			    resultDialog.setTitle("RESULT SEARCH");
			    resultDialog.setVisible(true);
			    
			}
		});
		
		add(colName);
		add(atributeTxt);
		add(operationName);
		add(comboBoxOperation);
		add(value);
		add(valueTxt);
		add(parSort);
		add(parSorttxt);
		add(orderSort);
		add(sortBox);
		add(next);
		add(done);
		setLayout(new GridLayout(7, 2));
		setPreferredSize(new Dimension(1222, 876));
		setLocationRelativeTo(null);
		setTitle("Search");
		pack();
		setVisible(true);
	}
}
