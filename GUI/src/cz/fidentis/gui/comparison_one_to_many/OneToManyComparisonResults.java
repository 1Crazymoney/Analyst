/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui.comparison_one_to_many;

import cz.fidentis.comparison.ComparisonMethod;
import cz.fidentis.comparison.ICPmetric;
import cz.fidentis.comparison.RegistrationMethod;
import cz.fidentis.controller.OneToManyComparison;
import cz.fidentis.gui.GUIController;
import cz.fidentis.gui.PlotsDrawingPanelAuxiliary;
import cz.fidentis.gui.ProjectTopComponent;
import cz.fidentis.gui.TableProcessing;
import cz.fidentis.model.Model;
import cz.fidentis.model.ModelExporter;
import cz.fidentis.model.ModelLoader;
import cz.fidentis.processing.comparison.surfaceComparison.SurfaceComparisonProcessing;
import cz.fidentis.processing.exportProcessing.ResultExports;
import cz.fidentis.undersampling.Methods;
import cz.fidentis.undersampling.Type;
import cz.fidentis.utils.FileUtils;
import cz.fidentis.visualisation.ColorScheme;
import cz.fidentis.visualisation.ColorSelector;
import cz.fidentis.visualisation.histogram.histogramPanel;
import cz.fidentis.visualisation.surfaceComparison.HDpainting;
import cz.fidentis.visualisation.surfaceComparison.HDpaintingInfo;
import cz.fidentis.visualisation.surfaceComparison.SelectionType;
import cz.fidentis.visualisation.surfaceComparison.VisualizationType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.imageio.ImageIO;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.vecmath.Vector3f;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.util.Exceptions;

/**
 *
 * @author Katka
 */
public class OneToManyComparisonResults extends javax.swing.JPanel {

    JPanel activeColorPanel;
    String result;
    private boolean tresholdValueChanged;
    private ColorScheme heatplotColorScheme = ColorScheme.GREEN_BLUE;
    private boolean valuesModified = false;

    /**
     * Creates new form OneToManyComparisonResults
     */
    public OneToManyComparisonResults() {
        initComponents();
        activeColorPanel = new JPanel();
    }

    public void showProcrustesControls() {
        jPanel1.setVisible(false);
        slicesPanel.setVisible(false);
        colorMapPanel.setVisible(false);
        densLabel.setVisible(false);
        density.setVisible(false);
        jPanel2.setVisible(true);
        jButton10.setVisible(false);
        jButton6.setVisible(false);
        comparisonButton.setVisible(false);
        exportOrderedResultsButton.setVisible(false);
        jSpinner1.setVisible(false);
        jSlider1.setVisible(false);
        jLabel7.setVisible(false);
    }

    public void showHausdorfControls() {
        jLabel5.setVisible(true);
        jComboBox2.setVisible(true);
        jPanel2.setVisible(false);
        comparisonButton.setVisible(true);
        jPanel1.setVisible(true);
        jButton10.setVisible(true);
        jButton6.setVisible(true);
        exportOrderedResultsButton.setVisible(true);
        jSpinner1.setVisible(true);
        jSlider1.setVisible(true);
        jLabel7.setVisible(true);

        if (VisualizationBox.getSelectedItem().equals(VisualizationType.COLORMAP.toString())) {
            densLabel.setVisible(false);
            density.setVisible(false);
            colorMapPanel.setVisible(true);
            slicesPanel.setVisible(false);
        }
        if (VisualizationBox.getSelectedItem().equals(VisualizationType.VECTORS.toString())) {
            densLabel.setVisible(true);
            density.setVisible(true);
            colorMapPanel.setVisible(false);
            slicesPanel.setVisible(false);
        }
        if (VisualizationBox.getSelectedItem().equals(VisualizationType.CROSSSECTION.toString())) {
            densLabel.setVisible(false);
            density.setVisible(false);
            colorMapPanel.setVisible(false);
            slicesPanel.setVisible(true);
        }
        this.revalidate();
    }

    public void setNumericalResult(String result) {
        this.result = result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorDialog = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pairFrame = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        pairComparisonPanel1 = new cz.fidentis.gui.PairComparisonPanel();
        jFrame4 = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        plotsDrawingPanelAuxiliary2 = new cz.fidentis.gui.PlotsDrawingPanelAuxiliary();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        alignFrame = new javax.swing.JFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        alignTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        VisualizationBox = new javax.swing.JComboBox();
        comparisonButton = new javax.swing.JButton();
        slicesPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        normalSpinnerX = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        normalSpinnerY = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        normalSpinnerZ = new javax.swing.JSpinner();
        positionSpinnerZ = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        positionSpinnerY = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        positionSpinnerX = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSlider3 = new javax.swing.JSlider();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        colorPanel = new javax.swing.JPanel();
        thickness = new javax.swing.JSlider();
        densLabel1 = new javax.swing.JLabel();
        densLabel2 = new javax.swing.JLabel();
        colorMapPanel = new javax.swing.JPanel();
        histogram1 = new cz.fidentis.visualisation.histogram.histogramPanel();
        jLabel7 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSpinner1 = new javax.swing.JSpinner();
        selectionButton = new javax.swing.JToggleButton();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSlider2 = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        sizeSlider = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        density = new javax.swing.JSlider();
        densLabel = new javax.swing.JLabel();
        heatplotButton = new javax.swing.JButton();
        exportOrderedResultsButton = new javax.swing.JButton();
        heatplotButton1 = new javax.swing.JButton();
        alignParametersButton = new javax.swing.JButton();
        cylLengthLabel = new javax.swing.JLabel();
        cylLength = new javax.swing.JSlider();
        cylRadius = new javax.swing.JSlider();
        cylRadiusLabel = new javax.swing.JLabel();

        Dimension dimension = new Dimension();
        dimension.setSize(jColorChooser1.getPreferredSize().width + 5, jColorChooser1.getPreferredSize().height+80);
        colorDialog.setMinimumSize(dimension);
        colorDialog.setModal(true);
        colorDialog.setResizable(false);

        org.openide.awt.Mnemonics.setLocalizedText(jButton4, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton4.text")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton5, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton5.text")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorDialogLayout = new javax.swing.GroupLayout(colorDialog.getContentPane());
        colorDialog.getContentPane().setLayout(colorDialogLayout);
        colorDialogLayout.setHorizontalGroup(
            colorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(6, 6, 6))
        );
        colorDialogLayout.setVerticalGroup(
            colorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorDialogLayout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(colorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(0, 69, Short.MAX_VALUE))
        );

        colorDialog.getAccessibleContext().setAccessibleParent(this);

        jDialog1.setModal(true);
        jDialog1.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        jDialog1.setName("Numerical results "); // NOI18N
        jDialog1.getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable3.setColumnSelectionAllowed(true);
        jTable3.getTableHeader().setResizingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable3);

        jDialog1.getContentPane().add(jScrollPane1);

        jFrame1.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);

        jFrame1.getContentPane().add(jScrollPane3);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(0, 1, 1, 0));
        jScrollPane4.setViewportView(jPanel5);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel1.text")); // NOI18N

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sequential", "Diverging", "Rainbow" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
        );

        javax.swing.GroupLayout pairFrameLayout = new javax.swing.GroupLayout(pairFrame.getContentPane());
        pairFrame.getContentPane().setLayout(pairFrameLayout);
        pairFrameLayout.setHorizontalGroup(
            pairFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pairFrameLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pairComparisonPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
        );
        pairFrameLayout.setVerticalGroup(
            pairFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pairComparisonPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        plotsDrawingPanelAuxiliary2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotsDrawingPanelAuxiliary2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plotsDrawingPanelAuxiliary2Layout = new javax.swing.GroupLayout(plotsDrawingPanelAuxiliary2);
        plotsDrawingPanelAuxiliary2.setLayout(plotsDrawingPanelAuxiliary2Layout);
        plotsDrawingPanelAuxiliary2Layout.setHorizontalGroup(
            plotsDrawingPanelAuxiliary2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );
        plotsDrawingPanelAuxiliary2Layout.setVerticalGroup(
            plotsDrawingPanelAuxiliary2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel19, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel19.text")); // NOI18N

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sequential", "Diverging", "Rainbow" }));
        jComboBox4.setSelectedIndex(1);
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel20, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel20.text")); // NOI18N

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Relative", "Absolute" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plotsDrawingPanelAuxiliary2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plotsDrawingPanelAuxiliary2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        alignFrame.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        alignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        alignTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        alignTable.setColumnSelectionAllowed(true);
        alignTable.getTableHeader().setResizingAllowed(false);
        alignTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(alignTable);

        alignFrame.getContentPane().add(jScrollPane5);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel2.text")); // NOI18N

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Root Mean Square", "Arithmetic Mean", "Geometric Mean", "Minimal Distance", "Maximal Distance", "Variance", "75 percentil" }));
        jComboBox3.setToolTipText(org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jComboBox3.toolTipText")); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel5.text")); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Relative", "Absolute" }));
        jComboBox2.setMinimumSize(new java.awt.Dimension(115, 206));
        jComboBox2.setPreferredSize(new java.awt.Dimension(115, 20));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel3.text")); // NOI18N

        VisualizationBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Color map", "Vectors", "Cross-sections" }));
        VisualizationBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizationBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VisualizationBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VisualizationBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(comparisonButton, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.comparisonButton.text")); // NOI18N
        comparisonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comparisonButtonActionPerformed(evt);
            }
        });

        slicesPanel.setName(""); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel8.text")); // NOI18N

        buttonGroup1.add(jRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jRadioButton1.text")); // NOI18N
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton5, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jRadioButton5.text")); // NOI18N
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton6, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jRadioButton6.text")); // NOI18N
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton7);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton7, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jRadioButton7.text")); // NOI18N
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel9.text")); // NOI18N
        jLabel9.setEnabled(false);

        normalSpinnerX.setModel(new javax.swing.SpinnerNumberModel(1.0f, null, null, 0.1f));
        normalSpinnerX.setEnabled(false);
        normalSpinnerX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                normalSpinnerXStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel12.text")); // NOI18N
        jLabel12.setEnabled(false);

        normalSpinnerY.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        normalSpinnerY.setEnabled(false);
        normalSpinnerY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                normalSpinnerYStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel13.text")); // NOI18N
        jLabel13.setEnabled(false);

        normalSpinnerZ.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        normalSpinnerZ.setEnabled(false);
        normalSpinnerZ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                normalSpinnerZStateChanged(evt);
            }
        });

        positionSpinnerZ.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.5f));
        positionSpinnerZ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                positionSpinnerZStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel14.text")); // NOI18N

        positionSpinnerY.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.5f));
        positionSpinnerY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                positionSpinnerYStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel15.text")); // NOI18N

        positionSpinnerX.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.5f));
        positionSpinnerX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                positionSpinnerXStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel16, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel16.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel17, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel17.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel18, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel18.text")); // NOI18N

        jSlider3.setMajorTickSpacing(10);
        jSlider3.setMinimum(10);
        jSlider3.setMinorTickSpacing(5);
        jSlider3.setPaintLabels(true);
        jSlider3.setPaintTicks(true);
        jSlider3.setToolTipText(org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jSlider3.toolTipText")); // NOI18N
        jSlider2.setValue(10);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jCheckBox3.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox3, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jCheckBox3.text")); // NOI18N
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox5, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jCheckBox5.text")); // NOI18N
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox4, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jCheckBox4.text")); // NOI18N
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox6.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox6, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jCheckBox6.text")); // NOI18N
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        colorPanel.setBackground(new java.awt.Color(255, 255, 255));
        colorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        colorPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        colorPanel.setEnabled(false);
        colorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        thickness.setMaximum(80);
        thickness.setMinimum(10);
        density.setVisible(false);
        densLabel.setVisible(false);
        thickness.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thicknessStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(densLabel1, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.densLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(densLabel2, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.densLabel2.text")); // NOI18N

        javax.swing.GroupLayout slicesPanelLayout = new javax.swing.GroupLayout(slicesPanel);
        slicesPanel.setLayout(slicesPanelLayout);
        slicesPanelLayout.setHorizontalGroup(
            slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slicesPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(slicesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(slicesPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(normalSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(normalSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(normalSpinnerZ, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(slicesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(positionSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(positionSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(positionSpinnerZ, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(slicesPanelLayout.createSequentialGroup()
                        .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(slicesPanelLayout.createSequentialGroup()
                                .addComponent(densLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thickness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(slicesPanelLayout.createSequentialGroup()
                                .addComponent(densLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(slicesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton7)
                                    .addGroup(slicesPanelLayout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton6))))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(slicesPanelLayout.createSequentialGroup()
                                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox4))
                                .addGap(23, 23, 23)
                                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox6)
                                    .addComponent(jCheckBox5))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        slicesPanelLayout.setVerticalGroup(
            slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slicesPanelLayout.createSequentialGroup()
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(normalSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(normalSpinnerZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(positionSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(positionSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(positionSpinnerZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(2, 2, 2)
                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thickness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(densLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(densLabel2)
                    .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(slicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Hashtable<Integer, JLabel> labels =
        new Hashtable<Integer, JLabel>();
        labels.put(10, new JLabel("1"));
        labels.put(20, new JLabel("2"));
        labels.put(30, new JLabel("3"));
        labels.put(40, new JLabel("4"));
        labels.put(50, new JLabel("5"));
        labels.put(60, new JLabel("6"));
        labels.put(70, new JLabel("7"));
        labels.put(80, new JLabel("8"));
        labels.put(90, new JLabel("9"));
        labels.put(100, new JLabel("10"));
        jSlider3.setLabelTable(labels);

        histogram1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                histogram1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout histogram1Layout = new javax.swing.GroupLayout(histogram1);
        histogram1.setLayout(histogram1Layout);
        histogram1Layout.setHorizontalGroup(
            histogram1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        histogram1Layout.setVerticalGroup(
            histogram1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel7.text")); // NOI18N

        jSlider1.setMajorTickSpacing(20);
        jSlider1.setMinorTickSpacing(5);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(75);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(100, 0, 100, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(selectionButton, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.selectionButton.text")); // NOI18N
        selectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton8, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton8.text")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rectangle", "Ellipse" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sequential", "Diverging", "Rainbow" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel21, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel21.text")); // NOI18N

        javax.swing.GroupLayout colorMapPanelLayout = new javax.swing.GroupLayout(colorMapPanel);
        colorMapPanel.setLayout(colorMapPanelLayout);
        colorMapPanelLayout.setHorizontalGroup(
            colorMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorMapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(histogram1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(colorMapPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(colorMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorMapPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(colorMapPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(selectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(colorMapPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        colorMapPanelLayout.setVerticalGroup(
            colorMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorMapPanelLayout.createSequentialGroup()
                .addGroup(colorMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(colorMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(histogram1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(colorMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectionButton)
                    .addComponent(jButton8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSlider2.setMajorTickSpacing(20);
        jSlider2.setMinorTickSpacing(5);
        jSlider2.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setValue(0);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(sizeLabel, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.sizeLabel.text")); // NOI18N

        sizeSlider.setMajorTickSpacing(20);
        sizeSlider.setMaximum(50);
        sizeSlider.setMinimum(10);
        sizeSlider.setMinorTickSpacing(5);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setValue(30);
        sizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sizeSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton6, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton6.text")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton10, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton10.text")); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton7, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.jButton7.text")); // NOI18N
        jButton7.setMaximumSize(new java.awt.Dimension(300, 28));
        jButton7.setMinimumSize(new java.awt.Dimension(280, 28));
        jButton7.setPreferredSize(new java.awt.Dimension(281, 28));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        density.setMajorTickSpacing(10);
        density.setMinorTickSpacing(5);
        density.setPaintLabels(true);
        density.setPaintTicks(true);
        density.setValue(10);
        density.setVisible(false);
        densLabel.setVisible(false);

        org.openide.awt.Mnemonics.setLocalizedText(densLabel, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.densLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(heatplotButton, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.heatplotButton.text")); // NOI18N
        heatplotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heatplotButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(exportOrderedResultsButton, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.exportOrderedResultsButton.text")); // NOI18N
        exportOrderedResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportOrderedResultsButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(heatplotButton1, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.heatplotButton1.text")); // NOI18N
        heatplotButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heatplotButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(alignParametersButton, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.alignParametersButton.text")); // NOI18N
        alignParametersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alignParametersButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cylLengthLabel, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.cylLengthLabel.text")); // NOI18N

        cylLength.setMajorTickSpacing(1);
        cylLength.setMaximum(10);
        cylLength.setMinimum(1);
        cylLength.setPaintLabels(true);
        cylLength.setPaintTicks(true);
        cylLength.setSnapToTicks(true);
        cylLength.setValue(1);
        cylLength.setVisible(false);  cylLengthLabel.setVisible(false);

        cylRadius.setMajorTickSpacing(1);
        cylRadius.setMaximum(10);
        cylRadius.setMinimum(1);
        cylRadius.setPaintLabels(true);
        cylRadius.setPaintTicks(true);
        cylRadius.setValue(1);
        cylRadius.setVisible(false);
        cylRadiusLabel.setVisible(false);

        org.openide.awt.Mnemonics.setLocalizedText(cylRadiusLabel, org.openide.util.NbBundle.getMessage(OneToManyComparisonResults.class, "OneToManyComparisonResults.cylRadiusLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cylRadiusLabel)
                        .addGap(18, 18, 18)
                        .addComponent(cylRadius, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(alignParametersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(heatplotButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(exportOrderedResultsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slicesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(comparisonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorMapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heatplotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cylLengthLabel)
                            .addComponent(densLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(density, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cylLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(density, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(densLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cylLengthLabel)
                    .addComponent(cylLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cylRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cylRadiusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorMapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comparisonButton)
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportOrderedResultsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heatplotButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heatplotButton1)
                .addGap(10, 10, 10)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alignParametersButton)
                .addGap(24, 24, 24)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        colorDialog.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        colorDialog.setVisible(false);
        activeColorPanel.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void exportOrderedResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportOrderedResultsButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        List<ArrayList<Float>> numResults = tc.getProject().getSelectedOneToManyComparison().getNumResults();
        List<Float> thresholdedValues;
        thresholdedValues = SurfaceComparisonProcessing.instance().compareOneToManyVariation(numResults, ((Integer) jSpinner1.getValue()) / 100f, jComboBox3.getSelectedIndex(), jComboBox2.getSelectedIndex() == 0);
        ResultExports.instance().exportCSVnumericOrder(tc, thresholdedValues, tc.getProject().getSelectedOneToManyComparison().getModels());
    }//GEN-LAST:event_exportOrderedResultsButtonActionPerformed

    private void heatplotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heatplotButtonActionPerformed
        if (result != null) {
            jPanel4.setVisible(true);

            setHeatPlotLabels();

            pairFrame.setTitle(
                    "Pairwise results");
            Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);

            pairFrame.setIconImage(icon);

            pairFrame.setVisible(
                    true);
            pairFrame.setSize(
                    1000, 500);
            pairFrame.setLocationRelativeTo(GUIController.getSelectedProjectTopComponent());

        }
    }//GEN-LAST:event_heatplotButtonActionPerformed

    private void setHeatPlotLabels() {
        //    int m = result.split("\n").length;
        int n = result.split("\n")[0].split(";").length;
        String[] valuesString = new String[n];
        String[] namesString = new String[n];

        namesString = result.split("\n")[0].split(";");
        valuesString = result.split("\n")[1].split(";");
        float values[] = new float[n - 1];
        float maxValue = Float.MIN_VALUE;
        float minValue = Float.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            values[i - 1] = Float.valueOf(valuesString[i]);
            if (values[i - 1] > maxValue) {
                maxValue = values[i - 1];
            }
            if (values[i - 1] < minValue) {
                minValue = values[i - 1];
            }
        }
        float distance = maxValue - minValue;
        jPanel5.removeAll();
        for (int i = 0; i < n - 1; i++) {
            final int j = i;
            JLabel l = new JLabel(namesString[i + 1]);
            //   JLabel l2 = new JLabel(namesString[i+1]);
            l.setToolTipText(Float.toString(values[i]));
            //  l.setText(Float.toString(values[i]));
            float v = values[i];
            v = v - minValue;
            ColorSelector s = new ColorSelector();
            Color b = s.chooseColor(0, distance, v, heatplotColorScheme);
            /*Color b = Color.getHSBColor(v, 1, 1);*/
            l.setBackground(b);
            // l.setForeground(b);
            l.setOpaque(true);
            //  jPanel5.add(l2);;
            jPanel5.add(l);
            l.setLocation(0, 31*i);
            l.setSize(jPanel5.getWidth(), 30);
            l.setPreferredSize(new Dimension(jPanel5.getWidth(), 30));
            l.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    OneToManyComparison bc = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison();
                    ModelLoader ml = new ModelLoader();
                    // pairComparisonPanel1.clear();
                    pairComparisonPanel1.getListener().removeModel();
                    List<File> models;
                    if (bc.getRegistrationMethod() == RegistrationMethod.NO_REGISTRATION) {
                        models = bc.getModels();
                    } else {
                        models = bc.getRegisteredModels();
                    }

                    Model primary = bc.getPrimaryModel();
                    pairComparisonPanel1.getListener().addModel(primary);
                    pairComparisonPanel1.getListener().addModel(ml.loadModel(models.get(j), false, false));
                    pairFrame.setTitle("Pairwise results - "+primary.getName()+" vs. " + models.get(j).getName());
                    
                    List<Float> values = bc.getNumResults().get(j);
                    HDpaintingInfo info = new HDpaintingInfo(values, primary, true);
                    HDpainting hdp = new HDpainting(info);
                    pairComparisonPanel1.getListener().setHdPaint(hdp);
                    pairComparisonPanel1.getListener().setHdInfo(info);
                    pairComparisonPanel1.setInfo(hdp);
                    pairComparisonPanel1.getListener().setPaintHD(true);
                    pairComparisonPanel1.revalidate();
                    pairComparisonPanel1.repaint();
                }

            }
            );

        }
        jPanel5.revalidate();
        jPanel5.repaint();

    }


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().setState(2);
        GUIController.getConfigurationTopComponent().addOneToManyComparisonComponent();
        ModelLoader ml = new ModelLoader();
        Model m = ml.loadModel(GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getModel(0), false, true);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().drawHD(false);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setProcrustes(false);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setModel1(GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getPrimaryModel());
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setModel2(m);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setFacialPoints(
                GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getFacialPoints(m.getName())
        );

        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().rotationAndSizeRestart();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //no export of avg face?
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ResultExports.instance().saveRegisteredModelsOneToMany(tc, tc.getProject().getSelectedOneToManyComparison().getRegisteredModels(),
                tc.getProject().getSelectedOneToManyComparison().getModels(),
                tc.getProject().getSelectedOneToManyComparison().getPrimaryModel(), "_1n");
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * This method saves current visualisation shown in the panel after pushing
     * saving button into a png file
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        if (tc.getProject().getSelectedOneToManyComparison().getHdPaintingInfo().getvType() == VisualizationType.CROSSSECTION) {
            ResultExports.instance().exportVisualResults(tc, tc.getOneToManyViewerPanel().getListener2(), 1920, 1920);
        } else {
            ResultExports.instance().exportVisualResults(tc, tc.getOneToManyViewerPanel().getListener1(), 1920, 1920);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ResultExports.instance().saveAuxOneToMany(tc, tc.getProject().getSelectedOneToManyComparison().getNumResults(),
                tc.getProject().getSelectedOneToManyComparison().getHd(),
                tc.getProject().getSelectedOneToManyComparison().getModels(),
                tc.getOneToManyViewerPanel().getListener1().getModel().getName(), jComboBox2.getSelectedIndex() == 0);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * This method is help method for saving numerical result as table
     *
     * @param file results should be saved into this file
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ResultExports.instance().exportCSVnumeric(tc, result);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(result != null){
            String[][] values = TableProcessing.instance().parseTable(result);
            
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    values,
                    values[0]
            ));
        }
        
        TableProcessing.instance().setUpTable(jTable1, jFrame1, GUIController.getSelectedProjectTopComponent(), "Numerical results");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sizeSliderStateChanged

        if (GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getComparisonMethod() == ComparisonMethod.PROCRUSTES) {
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().getPaInfo().setPointSize(sizeSlider.getValue() * 3);
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().setFpSize(sizeSlider.getValue());
        }
    }//GEN-LAST:event_sizeSliderStateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().getPaInfo().setEnhance(jSlider2.getValue());

        //GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setEnhance(jSlider2.getValue());
        repaint();
        GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().setFpDistance(jSlider2.getValue());
    }//GEN-LAST:event_jSlider2StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedItem().equals(SelectionType.RECTANGLE.toString())) {
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo().setsType(SelectionType.RECTANGLE);
        }
        if (jComboBox1.getSelectedItem().equals(SelectionType.ELLIPSE.toString())) {
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo().setsType(SelectionType.ELLIPSE);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().clearSelection();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void selectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionButtonActionPerformed
        if (jComboBox1.getSelectedItem().equals(SelectionType.RECTANGLE.toString())) {
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo().setsType(SelectionType.RECTANGLE);
        }
        if (jComboBox1.getSelectedItem().equals(SelectionType.ELLIPSE.toString())) {
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo().setsType(SelectionType.ELLIPSE);
        }
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setSelection(selectionButton.isSelected());
    }//GEN-LAST:event_selectionButtonActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        if (!tresholdValueChanged
                && GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getComparisonMethod() != ComparisonMethod.PROCRUSTES) {
            tresholdValueChanged = true;
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().setHausdorfTreshold(Integer.valueOf(jSpinner1.getValue().toString()));
            jSlider1.setValue(GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHausdorfTreshold());
            setMaxValue();
        }
        tresholdValueChanged = false;
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        if (!tresholdValueChanged
                && GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getComparisonMethod() != ComparisonMethod.PROCRUSTES) {
            tresholdValueChanged = true;
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().setHausdorfTreshold(jSlider1.getValue());
            jSpinner1.setValue(GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHausdorfTreshold());

            setMaxValue();
        }

        HDpaintingInfo info = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo();

        if (info != null) {
            //        info.setThreshPecent((float) jSlider1.getValue() / 100);
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void setMaxValue() {
        float usedValues;
        List<Float> list;

        if (jComboBox2.getSelectedIndex() == 0) {
            list = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getSortedHdRel();
        } else {
            list = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getSortedHdAbs();

        }

        int size = list.size();
        int index = (int) (size * (jSlider1.getValue() / 100f));

        if (index == 0) {
            usedValues = list.get(0);
        } else {
            usedValues = list.get(index - 1);
        }

        HDpaintingInfo info = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo();
        info.setThreshValue(usedValues);
        updateHistograms();

        tresholdValueChanged = false;
    }

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setShowVectors(jCheckBox6.isSelected());
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setShowAllCuts(jCheckBox4.isSelected());
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setShowSamplingRays(jCheckBox5.isSelected());
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener1().setHighlightCuts(jCheckBox3.isSelected());
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setVectroScale(jSlider3.getValue() / (float) 10);
    }//GEN-LAST:event_jSlider3StateChanged

    private void positionSpinnerXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_positionSpinnerXStateChanged
        if(!valuesModified){
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlanePoint(new Vector3f((float) positionSpinnerX.getValue(), (float) positionSpinnerY.getValue(), (float) positionSpinnerZ.getValue()), true);       
        }
    }//GEN-LAST:event_positionSpinnerXStateChanged

    private void positionSpinnerYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_positionSpinnerYStateChanged
       if(!valuesModified){
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlanePoint(new Vector3f((float) positionSpinnerX.getValue(), (float) positionSpinnerY.getValue(), (float) positionSpinnerZ.getValue()), true);       
        }
    }//GEN-LAST:event_positionSpinnerYStateChanged

    private void positionSpinnerZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_positionSpinnerZStateChanged
        if(!valuesModified){
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlanePoint(new Vector3f((float) positionSpinnerX.getValue(), (float) positionSpinnerY.getValue(), (float) positionSpinnerZ.getValue()), true);       
        }
    }//GEN-LAST:event_positionSpinnerZStateChanged

    private void normalSpinnerZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_normalSpinnerZStateChanged
        if (normalSpinnerZ.isEnabled()&& !valuesModified) {
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f((float) normalSpinnerX.getValue(), (float) normalSpinnerY.getValue(), (float) normalSpinnerZ.getValue()), true);
        }
    }//GEN-LAST:event_normalSpinnerZStateChanged

    private void normalSpinnerYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_normalSpinnerYStateChanged
        if (normalSpinnerY.isEnabled()&& !valuesModified) {
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f((float) normalSpinnerX.getValue(), (float) normalSpinnerY.getValue(), (float) normalSpinnerZ.getValue()), true);
        }
    }//GEN-LAST:event_normalSpinnerYStateChanged

    private void normalSpinnerXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_normalSpinnerXStateChanged
        if (normalSpinnerX.isEnabled() && !valuesModified) {
            GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f((float) normalSpinnerX.getValue(), (float) normalSpinnerY.getValue(), (float) normalSpinnerZ.getValue()), true);
        }
    }//GEN-LAST:event_normalSpinnerXStateChanged

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        if (jRadioButton7.isSelected()) {
            setNormalControlsEnabled(true);
        }
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f((float) normalSpinnerX.getValue(), (float) normalSpinnerY.getValue(), (float) normalSpinnerZ.getValue()), true);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed

        setNormalControlsEnabled(false);
        normalSpinnerX.setValue(0f);
        normalSpinnerY.setValue(1f);
        normalSpinnerZ.setValue(0f);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f(0f, 1f, 0f), true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        setNormalControlsEnabled(false);
        normalSpinnerX.setValue(1f);
        normalSpinnerY.setValue(0f);
        normalSpinnerZ.setValue(0f);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f(1f, 0f, 0f), true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        setNormalControlsEnabled(false);
        normalSpinnerX.setValue(0f);
        normalSpinnerY.setValue(0f);
        normalSpinnerZ.setValue(1f);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().setPlaneNormal(new Vector3f(0f, 0f, 1f), true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void comparisonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comparisonButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        Runnable run = new Runnable() {

            @Override
            public void run() {
                ProgressHandle p;
                List<Float> hdDistance = tc.getProject().getSelectedOneToManyComparison().getHd();
                List<ArrayList<Float>> numResults = tc.getProject().getSelectedOneToManyComparison().getNumResults();
                List<Float> thresholdedValues;
                List<File> origModels = tc.getProject().getSelectedOneToManyComparison().getModels();

                p = ProgressHandleFactory.createHandle("Computing comparison...");
                p.start();

                try {

                    if (jComboBox2.getSelectedIndex() == 1) {         //absolute is set
                        List<Float> absolute = new ArrayList<Float>();
                        for (Float hdDistance1 : hdDistance) {
                            absolute.add(Math.abs(hdDistance1));
                        }

                        hdDistance = absolute;
                    }

                    HDpaintingInfo info = tc.getProject().getSelectedOneToManyComparison().getHdPaintingInfo();

                    if (VisualizationBox.getSelectedItem().equals(VisualizationType.COLORMAP.toString())) {
                        tc.getOneToManyViewerPanel().getListener2().setPaintHD(false);
                        info.setvType(VisualizationType.COLORMAP);
                        tc.getOneToManyViewerPanel().getListener2().removeModel();
                        ModelLoader l = new ModelLoader();
                        Model modelShown = tc.getProject().getSelectedOneToManyComparison().getAvgFace();

                        if (modelShown == null) {
                            if (tc.getProject().getSelectedOneToManyComparison().getRegistrationMethod() == RegistrationMethod.HAUSDORFF) {

                                File m = tc.getProject().getSelectedOneToManyComparison().getRegisteredModels().get(0);
                                modelShown = l.loadModel(m, false, false);
                            } else {
                                File f = tc.getProject().getSelectedOneToManyComparison().getModels().get(0);
                                modelShown = l.loadModel(f, false, true);
                            }
                        }

                        tc.getOneToManyViewerPanel().getListener2().addModel(modelShown);

                    }
                    if (VisualizationBox.getSelectedItem().equals(VisualizationType.VECTORS.toString())) {
                        tc.getOneToManyViewerPanel().getListener2().setPaintHD(false);
                        info.setvType(VisualizationType.VECTORS);
                        info.setLenghtFactor(3.0f);
                        ModelLoader l = new ModelLoader();

                        Model modelShown = tc.getProject().getSelectedOneToManyComparison().getAvgFace();

                        if (modelShown == null) {
                            if (tc.getProject().getSelectedOneToManyComparison().getRegistrationMethod() == RegistrationMethod.HAUSDORFF) {

                                File m = tc.getProject().getSelectedOneToManyComparison().getRegisteredModels().get(0);
                                modelShown = l.loadModel(m, false, false);
                            } else {
                                File f = tc.getProject().getSelectedOneToManyComparison().getModels().get(0);
                                modelShown = l.loadModel(f, false, true);
                            }
                        }

                        tc.getOneToManyViewerPanel().getListener2().setModels(modelShown);
                    }
                    if (VisualizationBox.getSelectedItem().equals(VisualizationType.CROSSSECTION.toString())) {
                        tc.getOneToManyViewerPanel().getListener2().setSecondaryListener(true);
                        tc.getOneToManyViewerPanel().getListener2().setHdInfo(info);
                        tc.getOneToManyViewerPanel().getListener2().setPaintHD(true);
                        tc.getOneToManyViewerPanel().getListener1().setPlanePoint(new Vector3f((float) positionSpinnerX.getValue(), (float) positionSpinnerY.getValue(), (float) positionSpinnerZ.getValue()));
                        ModelLoader l = new ModelLoader();
                        ArrayList<Model> models = new ArrayList<>();
                        models.add(tc.getProject().getSelectedOneToManyComparison().getPrimaryModel());
                        for (int i = 0; i < tc.getProject().getSelectedOneToManyComparison().getRegisteredModels().size(); i++) {
                            //registered models will be null if ICP wasn't used
                            Model m = l.loadModel(tc.getProject().getSelectedOneToManyComparison().getRegisteredModels().get(i), false, false);
                            models.add(m);
                        }
                        tc.getOneToManyViewerPanel().getListener2().setModels(models);
                        tc.getOneToManyViewerPanel().getListener1().setPrimaryModel();
                        tc.getOneToManyViewerPanel().setPlaneNormal(new Vector3f((float) normalSpinnerX.getValue(), (float) normalSpinnerY.getValue(), (float) normalSpinnerZ.getValue()), true);
                        //  tc.getOneToManyViewerPanel().getListener1().setPlaneNormal(new Vector3f((float) normalSpinnerX.getValue(), (float) normalSpinnerY.getValue(), (float) normalSpinnerZ.getValue()));

                        info.setvType(VisualizationType.CROSSSECTION);

                    }

                    info.setDensity(density.getValue());
                    info.setCylLengthFactor(cylLength.getValue());
                    info.setCylRadius(cylRadius.getValue());
                    info.setIndicesForNormals(info.getGraph().indicesFordDensityNormals(density.getValue()));
                    info.setRecompute(true);

                    thresholdedValues = SurfaceComparisonProcessing.instance().compareOneToManyVariation(numResults, ((Integer) jSpinner1.getValue()) / 100f, jComboBox3.getSelectedIndex(), jComboBox2.getSelectedIndex() == 0);

                    String res = setValues(thresholdedValues, origModels, jComboBox3.getSelectedIndex());

                    info.setDistance(hdDistance);
                    info.setUseRelative(jComboBox2.getSelectedIndex() == 0);
                    tc.getProject().getSelectedOneToManyComparison().setNumericalResults(res);
                    tc.getProject().getSelectedOneToManyComparison().setValuesTypeIndex(jComboBox2.getSelectedIndex());
                    tc.getProject().getSelectedOneToManyComparison().setMetricTypeIndex(jComboBox3.getSelectedIndex());

                    p.finish();

                    if (GUIController.getSelectedProjectTopComponent() == tc) {
                        GUIController.getConfigurationTopComponent().addOneToManyComparisonResults();
                    }
                    updateHistograms();
                } catch (Exception ex) {
                    p.finish();
                }
            }
        };

        Thread t = new Thread(run);
        t.start();
    }//GEN-LAST:event_comparisonButtonActionPerformed

    private void VisualizationBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizationBoxActionPerformed
        if (VisualizationBox.getSelectedItem().equals(VisualizationType.COLORMAP.toString())) {
           densLabel.setVisible(false);
            density.setVisible(false);
            cylLength.setVisible(false);
            cylLengthLabel.setVisible(false);
            cylRadius.setVisible(false);
            cylRadiusLabel.setVisible(false);
            colorMapPanel.setVisible(true);
            slicesPanel.setVisible(false);
        }
        if (VisualizationBox.getSelectedItem().equals(VisualizationType.VECTORS.toString())) {
            densLabel.setVisible(true);
            density.setVisible(true);
            cylLength.setVisible(true);
            cylLengthLabel.setVisible(true);
            cylRadius.setVisible(true);
            cylRadiusLabel.setVisible(true);
            colorMapPanel.setVisible(false);
            slicesPanel.setVisible(false);
        }
        if (VisualizationBox.getSelectedItem().equals(VisualizationType.CROSSSECTION.toString())) {
           densLabel.setVisible(false);
            density.setVisible(false);
            cylLength.setVisible(false);
            cylLengthLabel.setVisible(false);
            cylRadius.setVisible(false);
            cylRadiusLabel.setVisible(false);
            colorMapPanel.setVisible(false);
            slicesPanel.setVisible(true);
        }
        updateHistograms();
    }//GEN-LAST:event_VisualizationBoxActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        //  GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().setVariance(jComboBox2.getSelectedIndex());
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void histogram1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_histogram1MouseDragged
        List<Float> l = jComboBox2.getSelectedIndex() == 0 ? GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getSortedHdRel() : GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getSortedHdAbs();
        int count = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) < GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo().getThreshValue()) {
                count++;
            } else {
                break;
            }
        }
        float percent = count / (float) l.size();
        jSlider1.setValue((int) (percent * 100));
    }//GEN-LAST:event_histogram1MouseDragged

    private void heatplotButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heatplotButton1ActionPerformed
        OneToManyComparison bc = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison();

        ArrayList<ArrayList<Float>> res = new ArrayList<ArrayList<Float>>();
        /* if(jComboBox1.getSelectedIndex() == 0){
         res = bc.getHd();
         }else{*/
        res = (ArrayList<ArrayList<Float>>) bc.getNumResults();
        //  }

        float values[][] = new float[res.size()][res.get(0).size()];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                values[i][j] = res.get(i).get(j);
            }

        }
        String names[] = new String[GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getModels().size()];
        int i = 0;
        for (File f : GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getModels()) {
            names[i] = f.getName();
            i++;
        }

        plotsDrawingPanelAuxiliary2.setNames(names);
        plotsDrawingPanelAuxiliary2.setValues(values);

        plotsDrawingPanelAuxiliary2.repaint();
        jFrame4.setTitle("Auxiliary results");
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        jFrame4.setIconImage(icon);
        jFrame4.setVisible(true);
        jFrame4.setSize(500, 500);
        jFrame4.setLocationRelativeTo(GUIController.getSelectedProjectTopComponent());
        plotsDrawingPanelAuxiliary2.revalidate();
        plotsDrawingPanelAuxiliary2.repaint();
    }//GEN-LAST:event_heatplotButton1ActionPerformed

    private void plotsDrawingPanelAuxiliary2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotsDrawingPanelAuxiliary2MouseClicked
        final OneToManyComparison bc = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison();
        plotsDrawingPanelAuxiliary2.mouseClicked(evt);

        if (plotsDrawingPanelAuxiliary2.getSelectedModelIndex() > -1 && plotsDrawingPanelAuxiliary2.getSelectedModelIndex() < bc.getModels().size()) {
            pairComparisonPanel1.clear();
            jPanel4.setVisible(false);
            pairFrame.setVisible(true);
            pairFrame.setSize(500, 500);

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    ModelLoader ml = new ModelLoader();
                    pairComparisonPanel1.getListener().removeModel();
                    List<File> models;
                    if (bc.getRegistrationMethod() == RegistrationMethod.NO_REGISTRATION) {
                        models = bc.getModels();
                    } else {
                        models = bc.getRegisteredModels();
                    }

                    Model primary = bc.getPrimaryModel();
                    pairComparisonPanel1.getListener().addModel(primary);
                    pairComparisonPanel1.getListener().addModel(ml.loadModel(models.get(plotsDrawingPanelAuxiliary2.getSelectedModelIndex()), false, false));
                    List<Float> values = bc.getNumResults().get(plotsDrawingPanelAuxiliary2.getSelectedModelIndex());
                    HDpaintingInfo info = new HDpaintingInfo(values, primary, true);
                    HDpainting hdp = new HDpainting(info);
                    pairComparisonPanel1.getListener().setHdPaint(hdp);
                    pairComparisonPanel1.getListener().setHdInfo(info);
                    pairComparisonPanel1.setInfo(hdp);
                    pairComparisonPanel1.getListener().setPaintHD(true);
                    pairComparisonPanel1.revalidate();
                    pairComparisonPanel1.repaint();

                    pairFrame.setTitle(primary.getName() + " vs. " + pairComparisonPanel1.getListener().getModels().get(1));
                    Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);

                    pairFrame.setIconImage(icon);
                }

            };

            Thread t = new Thread(run);
            t.start();

        }
    }//GEN-LAST:event_plotsDrawingPanelAuxiliary2MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        plotsDrawingPanelAuxiliary2.setScheme(ColorScheme.values()[jComboBox4.getSelectedIndex()]);
        plotsDrawingPanelAuxiliary2.resetValues();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        plotsDrawingPanelAuxiliary2.setAbsolute(jComboBox5.getSelectedIndex() == 1);
        plotsDrawingPanelAuxiliary2.resetValues();
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        OneToManyComparison bc = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison();
        bc.getHDP().getInfo().setColorScheme(ColorScheme.values()[jComboBox6.getSelectedIndex()]);
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        heatplotColorScheme = ColorScheme.values()[jComboBox7.getSelectedIndex()];
        setHeatPlotLabels();
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void alignParametersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alignParametersButtonActionPerformed
        OneToManyComparison c = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison();
        String[][] values = TableProcessing.instance().alignmentInfoTable(c.getIcpMetric(), c.getScaleEnabled(), c.getICPerrorRate(), c.getICPmaxIteration(),
                -1, null, Methods.values()[c.getMethod()], Type.values()[c.getType()], c.getValue());
        
        alignTable.setModel(new javax.swing.table.DefaultTableModel(
                    values,
                    values[0]
            ));
        
        TableProcessing.instance().setUpTable(alignTable, alignFrame, GUIController.getSelectedProjectTopComponent(), "Alignment parameters");
    }//GEN-LAST:event_alignParametersButtonActionPerformed

    private void colorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorPanelMouseClicked
        activeColorPanel = colorPanel;
        jColorChooser1.setColor(colorPanel.getBackground());
        colorDialog.setVisible(true);
        GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setColorOfCuts(colorPanel.getBackground().getRGBColorComponents(new float[3]));
      
    }//GEN-LAST:event_colorPanelMouseClicked

    private void thicknessStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thicknessStateChanged
       GUIController.getSelectedProjectTopComponent().getOneToManyViewerPanel().getListener2().setCutThickness(thickness.getValue()/10f);
    }//GEN-LAST:event_thicknessStateChanged

    public void setPlaneNormal(Vector3f normal) {
        normalSpinnerX.setValue(normal.x);
        normalSpinnerY.setValue(normal.y);
        normalSpinnerZ.setValue(normal.z);
    }

    public void setPlanePoint(Vector3f p) {
        positionSpinnerX.setValue(p.x);
        positionSpinnerY.setValue(p.y);
        positionSpinnerZ.setValue(p.z);

    }

    public void setValuesModified(boolean valuesModified) {
        this.valuesModified = valuesModified;
    }
    
    
    
    

    private void setNormalControlsEnabled(boolean en) {
        normalSpinnerX.setEnabled(en);
        normalSpinnerY.setEnabled(en);
        normalSpinnerZ.setEnabled(en);
        jLabel9.setEnabled(en);
        jLabel12.setEnabled(en);
        jLabel13.setEnabled(en);
    }

    public histogramPanel getHistogram() {
        return histogram1;
    }

    private String setValues(List<Float> hdDistance, List<File> models, int varianceMethod) {
        StringBuilder strResults = new StringBuilder(SurfaceComparisonProcessing.instance().getNameOfVarianceMethod(varianceMethod) + ";");

        for (int i = 0; i < hdDistance.size(); i++) {
            strResults.append(models.get(i).getName()).append(';');
        }

        strResults.append("\nMain Face;");

        for (Float f : hdDistance) {
            strResults.append(f).append(';');
        }

        return strResults.toString();
    }

    public void setConfiguration() {
        jSpinner1.setVisible(false);
        jSlider1.setVisible(false);
        jLabel7.setVisible(false);

        OneToManyComparison c = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison();
        HDpainting info = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHDP();

        jSlider1.setValue(c.getHausdorfTreshold());
        jSpinner1.setValue(c.getHausdorfTreshold());
        jSlider2.setValue(c.getFpDistance());
        sizeSlider.setValue(c.getFpSize());
        jComboBox2.setSelectedIndex(c.getValuesTypeIndex());
        jComboBox3.setSelectedIndex(c.getMetricTypeIndex());

        if (/*c.getResults() == 0*/c.getComparisonMethod() == ComparisonMethod.PROCRUSTES) {
            showProcrustesControls();
        }
        if (c.getComparisonMethod() == ComparisonMethod.HAUSDORFF_CURV
                || c.getComparisonMethod() == ComparisonMethod.HAUSDORFF_DIST) {
            showHausdorfControls();
            if (c.getComparisonMethod() == ComparisonMethod.HAUSDORFF_CURV) {
                jLabel5.setVisible(false);
                jComboBox2.setVisible(false);
            }
            updateHistograms();
        }
        
        if(c.getRegistrationMethod() == RegistrationMethod.HAUSDORFF){
            alignParametersButton.setVisible(true);
        }else{
            alignParametersButton.setVisible(false);
        }
        thickness.setValue(10);
        result = c.getNumericalResults();

    }

    public void updateHistograms() {
        List<Float> f = GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHDP().getInfo().getDistance();

        histogram1.setHdp(GUIController.getSelectedProjectTopComponent().getProject().getSelectedOneToManyComparison().getHdPaintingInfo());
        histogram1.setValues(f);
        histogram1.recomputeSliderPosition();
        histogram1.validate();
        //    histogramPanel2.repaint();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox VisualizationBox;
    private javax.swing.JFrame alignFrame;
    private javax.swing.JButton alignParametersButton;
    private javax.swing.JTable alignTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog colorDialog;
    private javax.swing.JPanel colorMapPanel;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JButton comparisonButton;
    private javax.swing.JSlider cylLength;
    private javax.swing.JLabel cylLengthLabel;
    private javax.swing.JSlider cylRadius;
    private javax.swing.JLabel cylRadiusLabel;
    private javax.swing.JLabel densLabel;
    private javax.swing.JLabel densLabel1;
    private javax.swing.JLabel densLabel2;
    private javax.swing.JSlider density;
    private javax.swing.JButton exportOrderedResultsButton;
    private javax.swing.JButton heatplotButton;
    private javax.swing.JButton heatplotButton1;
    private cz.fidentis.visualisation.histogram.histogramPanel histogram1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JSpinner normalSpinnerX;
    private javax.swing.JSpinner normalSpinnerY;
    private javax.swing.JSpinner normalSpinnerZ;
    private cz.fidentis.gui.PairComparisonPanel pairComparisonPanel1;
    private javax.swing.JFrame pairFrame;
    private cz.fidentis.gui.PlotsDrawingPanelAuxiliary plotsDrawingPanelAuxiliary2;
    private javax.swing.JSpinner positionSpinnerX;
    private javax.swing.JSpinner positionSpinnerY;
    private javax.swing.JSpinner positionSpinnerZ;
    private javax.swing.JToggleButton selectionButton;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JSlider sizeSlider;
    private javax.swing.JPanel slicesPanel;
    private javax.swing.JSlider thickness;
    // End of variables declaration//GEN-END:variables
}