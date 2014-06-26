package imdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;
import imdb.ColorComboBoxEditor1;


public class MainForm extends JFrame {
	private Controller ctrl;
	
	public MainForm() {
		initComponents();
		addInitData();		
		ctrl = new Controller();
		addButtonF1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addButtonF1ActionPerformed(e);
			}
		});
			
		tagButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tagList.setModel(ctrl.getListTags());
			}
		});
	}
	
	public class ColorComboBoxEditor {		
		    Color colors[] = { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK};
		    //JFrame frame = new JFrame("Editable JComboBox");
		    //.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		    
		    //final JComboBox comboBox = new JComboBox(colors);
		   // comboBox.setEditable(true);
		    //comboBox.setEditor(new ColorComboBoxEditor1(Color.RED));
		    //frame.add(comboBox, BorderLayout.NORTH);

		   // frame.setSize(300, 200);
		   // frame.setVisible(true);
		  
		}
	

	private void addInitData() {
		tagList.setListData(Storage.getInstance().getTags().toArray());
		
		
		
		SaveF1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveF1ActionPerformed(e);
			}
		});
		

	}
	
	private void SaveF1ActionPerformed(ActionEvent e) {		
		System.out.println("Se agrega plot");
		System.out.println("Nœmero de plots "+Storage.getInstance().getPlots().size());
		Storage.getInstance().addPlot(nameF1.getText(), colorF1.getText());
		
		//Se limpian los valores
		nameF1.setText("");
		colorF1.setText("");
		
		System.out.println("Nœmero de plots DESPUES DE AGREGAR "+Storage.getInstance().getPlots().size());
		
		comboPlots.removeAllItems();
		
		for(Plot p : Storage.getInstance().getPlots()){
			comboPlots.addItem(p.getNombre());
		}
	}

	private void tagButtonActionPerformed(ActionEvent e) {
		System.out.println("tagButtonActionPerformed");
	}

	private void addButtonF1ActionPerformed(ActionEvent e) {
		int tag_add = tagList.getSelectedIndex();
		int plot = comboPlots.getSelectedIndex();
		
		
		String tag = Storage.getInstance().getTags().get(tag_add);
		System.out.println("tag_add "+tag_add + " Contenido TAG "+tag );
		System.out.println("plot "+plot + " plot "+Storage.getInstance().getPlots().get(plot));
		
		//Se obtiene el plot		
		Storage.getInstance().getPlots().get(plot).addTag(tag);
		
		//tagList.remove(tag_add); Checar el eliminar
		
		listPlottag.setListData(Storage.getInstance().getPlots().get(plot).getTags().toArray());

	}


	private void comboPlotsActionPerformed(ActionEvent e) {
		System.out.println("comboPlotsActionPerformed");

		int plot = comboPlots.getSelectedIndex();
		System.out.println("plot "+plot );
		
		if(plot!=-1)
			listPlottag.setListData(Storage.getInstance().getPlots().get(plot).getTags().toArray());

	}

	private void comboPlotsItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		tabbedPane1 = new JTabbedPane();
		panel2 = new JPanel();
		plotsH3 = new JPanel();
		label6 = new JLabel();
		color = new JLabel();
		nameF1 = new JTextField();
		colorF1 = new JTextField();
		SaveF1 = new JButton();
		plotsH4 = new JPanel();
		comboPlots = new JComboBox();
		label8 = new JLabel();
		scrollPane2 = new JScrollPane();
		listPlottag = new JList();
		label9 = new JLabel();
		scrollPane3 = new JScrollPane();
		tagList = new JList();
		label10 = new JLabel();
		tagButton = new JButton();
		addButtonF1 = new JButton();
		deleteButtonF1 = new JButton();
		label14 = new JLabel();
		conjunctiveRadio = new JRadioButton();
		disjunctiveRadio = new JRadioButton();
		plotsH5 = new JPanel();
		label11 = new JLabel();
		plotButtonF1 = new JButton();
		label13 = new JLabel();
		label12 = new JLabel();
		yearFrom = new JSpinner();
		yearTo = new JSpinner();
		panel3 = new JPanel();
		plotsH7 = new JPanel();
		scrollPane4 = new JScrollPane();
		list4 = new JList();
		label18 = new JLabel();
		scrollPane5 = new JScrollPane();
		list5 = new JList();
		label19 = new JLabel();
		okButton9 = new JButton();
		okButton10 = new JButton();
		okButton11 = new JButton();
		progressBar2 = new JProgressBar();
		plotsH8 = new JPanel();
		okButton12 = new JButton();
		panel1 = new JPanel();
		label1 = new JLabel();
		buttonBar = new JPanel();
		cancelButton = new JButton();
		helpButton = new JButton();

		//======== this ========
		setBackground(new Color(153, 153, 153));
		setResizable(false);
		setTitle("Seriology IMDb Project");
		setIconImage(new ImageIcon("C:\\Users\\Usuario2\\Desktop\\Ontologies project\\Data-Database-icon.png").getImage());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBackground(new Color(102, 102, 102));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setBackground(new Color(102, 102, 102));

				//======== tabbedPane1 ========
				{

					//======== panel2 ========
					{

						//======== plotsH3 ========
						{
							//plotsH3.setToolTipText("ddd");
							plotsH3.setBorder(new TitledBorder("Create Plot"));

							//---- label6 ----
							label6.setText("Name:");

							//---- color ----
							color.setText("Color:");

							//---- SaveF1 ----
							SaveF1.setText("Save");

							GroupLayout plotsH3Layout = new GroupLayout(plotsH3);
							plotsH3.setLayout(plotsH3Layout);
							plotsH3Layout.setHorizontalGroup(
								plotsH3Layout.createParallelGroup()
									.addGroup(plotsH3Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(plotsH3Layout.createParallelGroup()
											.addGroup(plotsH3Layout.createSequentialGroup()
												.addComponent(label6)
												.addGap(18, 18, 18)
												.addComponent(nameF1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(color)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(colorF1, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
											.addComponent(SaveF1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addContainerGap())
							);
							plotsH3Layout.setVerticalGroup(
								plotsH3Layout.createParallelGroup()
									.addGroup(plotsH3Layout.createSequentialGroup()
										.addGroup(plotsH3Layout.createParallelGroup()
											.addGroup(plotsH3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(colorF1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(color))
											.addGroup(plotsH3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(label6)
												.addComponent(nameF1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(SaveF1)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
						}

						
						
						//======== plotsH4 ========
						{
							//plotsH4.setToolTipText("ddd");
							plotsH4.setBorder(new TitledBorder("Tags"));

							//---- comboPlots ----
							comboPlots.addItemListener(new ItemListener() {
								@Override
								public void itemStateChanged(ItemEvent e) {
									comboPlotsItemStateChanged(e);
								}
							});
							comboPlots.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									comboPlotsActionPerformed(e);
								}
							});

							//---- label8 ----
							label8.setText("Select Plot:");

							//======== scrollPane2 ========
							{
								scrollPane2.setViewportView(listPlottag);
							}

							//---- label9 ----
							label9.setText("Tags in the Plot:");

							//======== scrollPane3 ========
							{
								scrollPane3.setViewportView(tagList);
							}

							//---- label10 ----
							label10.setText("Tag List:");
							
							
							
							//---- tagButton ----
							tagButton.setText("Execute");

							//---- addButtonF1 ----
							addButtonF1.setText("<");

							//---- deleteButtonF1 ----
							deleteButtonF1.setText(">");

							//---- label14 ----
							label14.setText("Tag Operator:");

							//---- conjunctiveRadio ----
							conjunctiveRadio.setText("Conjunctive");

							//---- disjunctiveRadio ----
							disjunctiveRadio.setText("Disjunctive");

							GroupLayout plotsH4Layout = new GroupLayout(plotsH4);
							plotsH4.setLayout(plotsH4Layout);
							plotsH4Layout.setHorizontalGroup(
								plotsH4Layout.createParallelGroup()
									.addGroup(plotsH4Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(plotsH4Layout.createParallelGroup()
											.addGroup(plotsH4Layout.createSequentialGroup()
												.addComponent(label14)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(conjunctiveRadio)
												.addGap(2, 2, 2)
												.addComponent(disjunctiveRadio)
												.addContainerGap())
											.addGroup(plotsH4Layout.createSequentialGroup()
												.addGroup(plotsH4Layout.createParallelGroup()
													.addComponent(label9)
													.addGroup(plotsH4Layout.createSequentialGroup()
														.addComponent(label8)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(comboPlots, 0, 108, Short.MAX_VALUE))
													.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(plotsH4Layout.createParallelGroup()
													.addComponent(deleteButtonF1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addComponent(addButtonF1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
												.addGap(11, 11, 11)
												.addGroup(plotsH4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
													.addGroup(plotsH4Layout.createSequentialGroup()
														.addComponent(label10)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
														.addComponent(tagButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(20, Short.MAX_VALUE))
													.addGroup(GroupLayout.Alignment.LEADING, plotsH4Layout.createSequentialGroup()
														.addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())))))
							);
							plotsH4Layout.setVerticalGroup(
								plotsH4Layout.createParallelGroup()
									.addGroup(plotsH4Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(plotsH4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label8)
											.addComponent(comboPlots, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(label10)
											.addComponent(tagButton))
										.addGap(11, 11, 11)
										.addComponent(label9)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(plotsH4Layout.createParallelGroup()
											.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
											.addGroup(plotsH4Layout.createSequentialGroup()
												.addComponent(addButtonF1)
												.addGap(18, 18, 18)
												.addComponent(deleteButtonF1)
												.addGap(92, 92, 92))
											.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(plotsH4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(conjunctiveRadio)
											.addComponent(disjunctiveRadio)
											.addComponent(label14)))
							);
						}

						//======== plotsH5 ========
						{
							//plotsH5.setToolTipText("ddd");
							plotsH5.setBorder(new TitledBorder("Query"));

							//---- label11 ----
							label11.setText("From:");

							//---- plotButtonF1 ----
							plotButtonF1.setText("PLOT");

							//---- label13 ----
							label13.setText("To:");

							//---- label12 ----
							label12.setText("Period Range:");

							GroupLayout plotsH5Layout = new GroupLayout(plotsH5);
							plotsH5.setLayout(plotsH5Layout);
							plotsH5Layout.setHorizontalGroup(
								plotsH5Layout.createParallelGroup()
									.addGroup(plotsH5Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(label12)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(label11)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(yearFrom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(label13)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(yearTo, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
										.addComponent(plotButtonF1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
							);
							plotsH5Layout.setVerticalGroup(
								plotsH5Layout.createParallelGroup()
									.addGroup(plotsH5Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(plotsH5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label12)
											.addComponent(label11)
											.addComponent(label13)
											.addComponent(plotButtonF1)
											.addComponent(yearFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(yearTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							);
						}

						GroupLayout panel2Layout = new GroupLayout(panel2);
						panel2.setLayout(panel2Layout);
						panel2Layout.setHorizontalGroup(
							panel2Layout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
									.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
											.addContainerGap()
											.addComponent(plotsH4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
											.addGap(13, 13, 13)
											.addComponent(plotsH5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
											.addContainerGap()
											.addComponent(plotsH3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addContainerGap())
						);
						panel2Layout.setVerticalGroup(
							panel2Layout.createParallelGroup()
								.addGroup(panel2Layout.createSequentialGroup()
									.addGap(16, 16, 16)
									.addComponent(plotsH3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(plotsH4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(plotsH5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
						);
					}
					tabbedPane1.addTab("Historical Tag Occurrence", panel2);


					//======== panel3 ========
					{

						//======== plotsH7 ========
						{
							//plotsH7.setToolTipText("ddd");
							plotsH7.setBorder(new TitledBorder("Series"));

							//======== scrollPane4 ========
							{
								scrollPane4.setViewportView(list4);
							}

							//---- label18 ----
							label18.setText("Plot Actor co-Appearance from:");

							//======== scrollPane5 ========
							{
								scrollPane5.setViewportView(list5);
							}

							//---- label19 ----
							label19.setText("Series List:");

							//---- okButton9 ----
							okButton9.setText("Execute");

							//---- okButton10 ----
							okButton10.setText("<");

							//---- okButton11 ----
							okButton11.setText(">");

							GroupLayout plotsH7Layout = new GroupLayout(plotsH7);
							plotsH7.setLayout(plotsH7Layout);
							plotsH7Layout.setHorizontalGroup(
								plotsH7Layout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, plotsH7Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(plotsH7Layout.createParallelGroup()
											.addComponent(label18)
											.addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(plotsH7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
											.addComponent(okButton11, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addComponent(okButton10, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(plotsH7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
											.addGroup(plotsH7Layout.createSequentialGroup()
												.addGap(10, 10, 10)
												.addComponent(label19)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(okButton9, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
											.addComponent(progressBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
										.addContainerGap(20, Short.MAX_VALUE))
							);
							plotsH7Layout.setVerticalGroup(
								plotsH7Layout.createParallelGroup()
									.addGroup(plotsH7Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(plotsH7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label19)
											.addComponent(okButton9))
										.addGap(11, 11, 11)
										.addGroup(plotsH7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
											.addComponent(label18)
											.addComponent(progressBar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(plotsH7Layout.createParallelGroup()
											.addGroup(plotsH7Layout.createSequentialGroup()
												.addComponent(okButton10)
												.addGap(18, 18, 18)
												.addComponent(okButton11))
											.addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
											.addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
										.addContainerGap())
							);
						}

						//======== plotsH8 ========
						{
							//plotsH8.setToolTipText("ddd");
							plotsH8.setBorder(new TitledBorder("Query"));

							//---- okButton12 ----
							okButton12.setText("PLOT");

							GroupLayout plotsH8Layout = new GroupLayout(plotsH8);
							plotsH8.setLayout(plotsH8Layout);
							plotsH8Layout.setHorizontalGroup(
								plotsH8Layout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, plotsH8Layout.createSequentialGroup()
										.addContainerGap(354, Short.MAX_VALUE)
										.addComponent(okButton12, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
							);
							plotsH8Layout.setVerticalGroup(
								plotsH8Layout.createParallelGroup()
									.addGroup(GroupLayout.Alignment.TRAILING, plotsH8Layout.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(okButton12)
										.addContainerGap())
							);
						}

						GroupLayout panel3Layout = new GroupLayout(panel3);
						panel3.setLayout(panel3Layout);
						panel3Layout.setHorizontalGroup(
							panel3Layout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
									.addContainerGap()
									.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(plotsH7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(plotsH8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addContainerGap())
						);
						panel3Layout.setVerticalGroup(
							panel3Layout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
									.addContainerGap()
									.addComponent(plotsH7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(plotsH8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
						);
					}
					tabbedPane1.addTab("Actor co-Appearance", panel3);


					//======== panel1 ========
					{

						GroupLayout panel1Layout = new GroupLayout(panel1);
						panel1.setLayout(panel1Layout);
						panel1Layout.setHorizontalGroup(
							panel1Layout.createParallelGroup()
								.addGap(0, 505, Short.MAX_VALUE)
						);
						panel1Layout.setVerticalGroup(
							panel1Layout.createParallelGroup()
								.addGap(0, 505, Short.MAX_VALUE)
						);
					}
					tabbedPane1.addTab("Explorer", panel1);

				}

				//---- label1 ----
				label1.setText("IMDb Graphs");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, 13f));
				label1.setForeground(Color.white);

				//======== buttonBar ========
				{
					buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
					buttonBar.setBackground(new Color(102, 102, 102));
					buttonBar.setLayout(new GridBagLayout());
					((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 85, 80};
					((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

					//---- cancelButton ----
					cancelButton.setText("Cancel");
					buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));

					//---- helpButton ----
					helpButton.setText("Help");
					buttonBar.add(helpButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				}

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
							.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(tabbedPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addComponent(buttonBar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
									.addGap(209, 209, 209)
									.addComponent(label1)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 219, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addComponent(label1)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(buttonBar, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addGap(3, 3, 3))
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JTabbedPane tabbedPane1;
	private JPanel panel2;
	private JPanel plotsH3;
	private JLabel label6;
	private JLabel color;
	private JTextField nameF1;
	private JTextField colorF1;
	private JButton SaveF1;
	private JPanel plotsH4;
	private JComboBox comboPlots;
	private JLabel label8;
	private JScrollPane scrollPane2;
	private JList listPlottag;
	private JLabel label9;
	private JScrollPane scrollPane3;
	private JList tagList;
	private JLabel label10;
	private JButton tagButton;
	private JButton addButtonF1;
	private JButton deleteButtonF1;
	private JLabel label14;
	private JRadioButton conjunctiveRadio;
	private JRadioButton disjunctiveRadio;
	private JPanel plotsH5;
	private JLabel label11;
	private JButton plotButtonF1;
	private JLabel label13;
	private JLabel label12;
	private JSpinner yearFrom;
	private JSpinner yearTo;
	private JPanel panel3;
	private JPanel plotsH7;
	private JScrollPane scrollPane4;
	private JList list4;
	private JLabel label18;
	private JScrollPane scrollPane5;
	private JList list5;
	private JLabel label19;
	private JButton okButton9;
	private JButton okButton10;
	private JButton okButton11;
	private JProgressBar progressBar2;
	private JPanel plotsH8;
	private JButton okButton12;
	private JPanel panel1;
	private JLabel label1;
	private JPanel buttonBar;
	private JButton cancelButton;
	private JButton helpButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
