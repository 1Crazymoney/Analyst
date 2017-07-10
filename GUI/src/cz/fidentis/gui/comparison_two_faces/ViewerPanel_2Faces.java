/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui.comparison_two_faces;

import cz.fidentis.featurepoints.FacialPoint;
import cz.fidentis.gui.Canvas;
import cz.fidentis.gui.ConfigurationTopComponent;
import cz.fidentis.gui.GUIController;
import cz.fidentis.gui.ProjectTopComponent;
import cz.fidentis.gui.ViewerPanel;
import cz.fidentis.gui.actions.landmarks.AddEditLandmarkDialogue;
import cz.fidentis.gui.actions.landmarks.EditLandmarkID;
import cz.fidentis.gui.observer.ObservableMaster;
import cz.fidentis.model.Model;
import cz.fidentis.renderer.ComparisonGLEventListener;
import cz.fidentis.utils.IntersectionUtils;
import cz.fidentis.utils.MathUtils;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.media.opengl.GLEventListener;
import javax.swing.SwingUtilities;
import javax.vecmath.Vector3f;

/**
 *
 * @author Katka
 */
public class ViewerPanel_2Faces extends javax.swing.JPanel implements ViewerPanel {

    private ProjectTopComponent projectComponent;

    private float mouseDraggedX, mouseDraggedY;
    private ComparisonGLEventListener listener2;
    private ComparisonGLEventListener listener1;
    private boolean manipulatePoint;
    private int nextIndexOfSelectedPoint;
    private int indexOfSelectedPoint;
    private boolean showInfo = true;
    private boolean editablePoints = false;
    private boolean removePoints = false;
    private boolean addPoints = false;
    private boolean selection = false;

    private ObservableMaster fpExportEnable;        //to check whether FPs can be exported once they are added, removed
    private boolean dragging;
    private Point draggingStart;
    private Point startGizmoCenter2D;
    private Vector3f startGizmoCenter3D;
    private Vector3f startPlanePoint;

    /**
     * Creates new form ViewerPanel
     */
    public ViewerPanel_2Faces(ProjectTopComponent tc) {
        projectComponent = tc;
        initComponents();
        listener2 = new ComparisonGLEventListener();
        listener1 = new ComparisonGLEventListener();
        canvas2.addGLEventListener(listener2);
        canvas1.addGLEventListener(listener1);
        listener1.setCameraPosition(0, 0, 300);
        listener2.setCameraPosition(0, 0, 300);

        canvas1.setImportLabelVisible(true);
        canvas2.setImportLabelVisible(true);

    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    @Override
    public ComparisonGLEventListener getListener2() {
        return listener2;
    }

    @Override
    public ComparisonGLEventListener getListener1() {
        return listener1;
    }

    public void setModel1(Model model) {
        listener1.setModels(model);
    }

    public void setModel2(Model model) {
        listener2.setModels(model);
    }

    public void addModel2(Model model) {
        listener2.addModel(model);
    }

    public void setFpExportEnable(ObservableMaster fpExportEnable) {
        this.fpExportEnable = fpExportEnable;
    }

    /*
     public void setViewerData(Viewer viewerData) {
     listener1.setModels(viewerData.getModel1());
     listener2.setModels(viewerData.getModel2());

     }*/
    public void setResultButtonVisible(boolean b, int canvasNumber) {
        if (canvasNumber == 0) {
            canvas1.setResultButtonVisible(b);
        } else {
            canvas2.setResultButtonVisible(b);
        }
    }

    public Canvas getCanvas1() {
        return canvas1;
    }

    public Canvas getCanvas2() {
        return canvas2;
    }

    public void checkFpAvaibility() {
        fpExportEnable.updateObservers();
    }

    public void resizeCanvas() {
        canvas2.resizeCanvas(jSplitPane1.getLeftComponent().getSize());
        canvas1.resizeCanvas(jSplitPane1.getLeftComponent().getSize());
    }

    public void setTextureRendering(Boolean b) {
        listener1.setDrawTextures(b);
        listener1.reloadTextures();
        listener2.setDrawTextures(b);
        listener2.reloadTextures();
    }

    public void showInfo(boolean show) {
        showInfo = show;
        canvas1.setFeaturePointsPanelVisibility(showInfo && (listener1.getIndexOfSelectedPoint() != -1));
        canvas2.setFeaturePointsPanelVisibility(showInfo && (listener2.getIndexOfSelectedPoint() != -1));
    }

    public void setEditablePoints(boolean b) {
        editablePoints = b;
        removePoints = false;
        addPoints = false;
    }

    public void setRemovePoints(boolean removePoints) {
        this.removePoints = removePoints;
        editablePoints = false;
        addPoints = false;
    }

    public void setAddPoints(boolean b) {
        this.addPoints = b;
        editablePoints = false;
        removePoints = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        canvas1 = new cz.fidentis.gui.Canvas(projectComponent, true);
        canvas2 = new cz.fidentis.gui.Canvas(projectComponent);

        jSplitPane1.setResizeWeight(0.5);

        canvas1.setMinimumSize(new java.awt.Dimension(300, 0));
        canvas1.setPreferredSize(new java.awt.Dimension(300, 0));
        canvas1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvas1MouseDragged(evt);
            }
        });
        canvas1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                canvas1MouseWheelMoved(evt);
            }
        });
        canvas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvas1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvas1MouseReleased(evt);
            }
        });
        jSplitPane1.setLeftComponent(canvas1);

        canvas2.setMinimumSize(new java.awt.Dimension(300, 0));
        canvas2.setPreferredSize(new java.awt.Dimension(300, 0));
        canvas2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvas2MouseDragged(evt);
            }
        });
        canvas2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                canvas2MouseWheelMoved(evt);
            }
        });
        canvas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvas2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvas2MouseReleased(evt);
            }
        });
        jSplitPane1.setRightComponent(canvas2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void canvas1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MousePressed

        canvasClicked(evt, listener1, canvas1);
        if (removePoints || addPoints) { //set new FP list for data model
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedComparison2Faces().setMainFp(listener1.getFacialPoints());    //TODO
            fpExportEnable.updateObservers();
        }

    }//GEN-LAST:event_canvas1MousePressed

    private void canvas2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas2MousePressed
        canvasClicked(evt, listener2, canvas2);
        if (removePoints || addPoints) {
            GUIController.getSelectedProjectTopComponent().getProject().getSelectedComparison2Faces().setSecondaryFp(listener2.getFacialPoints());  //TODO
            fpExportEnable.updateObservers();
        }


    }//GEN-LAST:event_canvas2MousePressed

    private void canvasClicked(MouseEvent evt, ComparisonGLEventListener listener, Canvas canvas) {
        mouseDraggedX = evt.getX();
        mouseDraggedY = evt.getY();

        manipulatePoint = listener.selectPoint(evt.getX(), evt.getY());
        if (manipulatePoint) {
            //update selected point                     
            setPointInfo(canvas, listener);

            if (editablePoints) {
                canvas.setInfo(listener.getFacialPoint(indexOfSelectedPoint));
                if (showInfo) {
                    canvas.setFeaturePointsPanelVisibility(true);
                }

                if (evt.getButton() == MouseEvent.BUTTON3) {   //edit window
                    EditLandmarkID d = new EditLandmarkID(listener.getFacialPoint(indexOfSelectedPoint), listener.getInfo(), canvas);
                    d.setVisible(true);
                }
            } else if (removePoints) {
                listener.getFacialPoints().remove(nextIndexOfSelectedPoint);
                listener.setIndexOfSelectedPoint(-1);

                if (showInfo) {        //no point is selected
                    canvas.setFeaturePointsPanelVisibility(false);

                }
            }

        } else if (selection && SwingUtilities.isLeftMouseButton(evt)) {
            listener.setSelectionStart(evt.getPoint());
        } else if (listener.getModel() != null) {        //pick point on the mesh
            Vector3f pos = listener.checkPointInMesh(evt.getX(), evt.getY());

            if (pos == null) {      //not on mesh, deselect
                listener.setIndexOfSelectedPoint(indexOfSelectedPoint = -1);
                if (showInfo) {
                    canvas.setFeaturePointsPanelVisibility(false);
                }
            } else {
                if (addPoints) { //on mesh plus add point

                    int id = listener.getInfo().getNextFreeFPID();
                    FacialPoint fp = new FacialPoint(id, pos);
                    listener.getInfo().addFacialPoint(fp);
                    listener.setIndexOfSelectedPoint(listener.getInfo().getFacialPoints().size() - 1);

                    if (showInfo) {
                        canvas.setFeaturePointsPanelVisibility(true);
                    }

                    setPointInfo(canvas, listener);
                }
            }
        }
    }

    private void setPointInfo(Canvas canvas, ComparisonGLEventListener listener) {
        nextIndexOfSelectedPoint = listener.getIndexOfSelectedPoint();

        //update selected point
        if (indexOfSelectedPoint != nextIndexOfSelectedPoint) {
            indexOfSelectedPoint = nextIndexOfSelectedPoint;
        }
        canvas.setInfo(listener.getFacialPoint(indexOfSelectedPoint));
    }

    private void canvas1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseDragged

        if (manipulatePoint && editablePoints) {
            if (listener1.editSelectedPoint(listener1.checkPointInMesh(evt.getX(), evt.getY()))) {
                canvas1.setCoordInfo(listener1.getFacialPoint(indexOfSelectedPoint));
            }
        } else if (SwingUtilities.isLeftMouseButton(evt)) {
            if (selection) {
                listener1.setSelectionEnd(evt.getPoint(), canvas1.getWidth(), canvas1.getHeight());
            } else {
                float x = evt.getX();
                float y = evt.getY();
                Dimension size = evt.getComponent().getSize();
                float thetaY = 360.0f * ((x - mouseDraggedX) / (float) size.width);
                float thetaX = 360.0f * ((mouseDraggedY - y) / (float) size.height);

                mouseDraggedX = x;
                mouseDraggedY = y;
                if (dragging) {
                    Vector3f xAxe = listener1.getXaxis();
                    Vector3f yAxe = listener1.getYaxis();
                    Vector3f n = new Vector3f(listener1.getPlaneNormal());
                    n = listener1.rotateAroundAxe(n, yAxe, Math.toRadians(thetaY));
                    n = listener1.rotateAroundAxe(n, xAxe, Math.toRadians(thetaX));
                    n.normalize();
                    setPlaneNormal(n, false);
                    GUIController.getConfigurationTopComponent().getPairComparisonResults().setValuesModified(true);
                    GUIController.getConfigurationTopComponent().getPairComparisonResults().setPlaneNormal(n);
                    GUIController.getConfigurationTopComponent().getPairComparisonResults().enableArbitraryNormal();
                    GUIController.getConfigurationTopComponent().getPairComparisonResults().setValuesModified(false);
                } else {
                    listener1.rotate(-thetaX, -thetaY);
                }

            }

        } else if (SwingUtilities.isRightMouseButton(evt)) {
            if (dragging) {
                shift(evt.getPoint());
            } else {
                float x = evt.getX();
                float y = evt.getY();
                Dimension size = evt.getComponent().getSize();
                float thetaX = 360.0f * ((x - mouseDraggedX) / (float) size.width);
                float thetaY = 360.0f * ((mouseDraggedY - y) / (float) size.height);

                listener1.move(thetaX, -thetaY);

                mouseDraggedX = x;
                mouseDraggedY = y;
            }
        }
    }//GEN-LAST:event_canvas1MouseDragged

     private void shift(Point destination) {
        double x = startGizmoCenter2D.x - draggingStart.x;
        double y = startGizmoCenter2D.x - draggingStart.y;
        double initialDistance = Math.sqrt(x * x + y * y);

        double distanceRatio = 1;
        distanceRatio = MathUtils.instance().distancePoints(listener1.getGizmoIntersection(), startGizmoCenter3D) / initialDistance;

        double k = (destination.x * x - draggingStart.x * x + destination.y * y - draggingStart.y * y) / (x * x + y * y);
        double distance = Math.sqrt(((-k * x) * (-k * x)) + ((-k * y) * (-k * y))) * distanceRatio;

        if (k > 0) {
            distance = -distance;
        }

        Vector3f n = new Vector3f(listener1.getPlaneNormal());
        n.normalize();
        n.scale((float) distance);

        Vector3f p = new Vector3f(startPlanePoint);
        p.add(n);
        setPlanePoint(p, false);
        GUIController.getConfigurationTopComponent().getPairComparisonResults().setValuesModified(true);
        GUIController.getConfigurationTopComponent().getPairComparisonResults().setPlanePoint(p);
        GUIController.getConfigurationTopComponent().getPairComparisonResults().enableArbitraryNormal();
        GUIController.getConfigurationTopComponent().getPairComparisonResults().setValuesModified(false);
    }
    
    private void canvas2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas2MouseDragged
        if (manipulatePoint && editablePoints) {
            if (listener2.editSelectedPoint(listener2.checkPointInMesh(evt.getX(), evt.getY()))) {
                canvas2.setCoordInfo(listener2.getFacialPoint(indexOfSelectedPoint));
            }
        } else if (SwingUtilities.isLeftMouseButton(evt)) {
            float x = evt.getX();
            float y = evt.getY();
            Dimension size = evt.getComponent().getSize();
            float thetaY = 360.0f * ((x - mouseDraggedX) / (float) size.width);
            float thetaX = 360.0f * ((mouseDraggedY - y) / (float) size.height);

            listener2.rotate(-thetaX, -thetaY);

            mouseDraggedX = x;
            mouseDraggedY = y;

        } else if (SwingUtilities.isRightMouseButton(evt)) {

            float x = evt.getX();
            float y = evt.getY();
            Dimension size = evt.getComponent().getSize();
            float thetaX = 360.0f * ((x - mouseDraggedX) / (float) size.width);
            float thetaY = 360.0f * ((mouseDraggedY - y) / (float) size.height);

            listener2.move(thetaX, -thetaY);

            mouseDraggedX = x;
            mouseDraggedY = y;

        }


    }//GEN-LAST:event_canvas2MouseDragged

    private void canvas1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_canvas1MouseWheelMoved
        if (evt.getWheelRotation() > 0) {
            listener1.zoomIn(-5 * evt.getWheelRotation());
        } else {
            listener1.zoomOut(5 * evt.getWheelRotation());

        }
    }//GEN-LAST:event_canvas1MouseWheelMoved

    private void canvas2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_canvas2MouseWheelMoved
        if (evt.getWheelRotation() > 0) {
            listener2.zoomIn(-5 * evt.getWheelRotation());
        } else {
            listener2.zoomOut(5 * evt.getWheelRotation());

        }
    }//GEN-LAST:event_canvas2MouseWheelMoved

    private void canvas2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas2MouseReleased
        manipulatePoint = false;

    }//GEN-LAST:event_canvas2MouseReleased

    public void clearSelection() {
        listener1.clearSelection();
        GUIController.getConfigurationTopComponent().getPairComparisonResults().updateHistograms();
        GUIController.getConfigurationTopComponent().getPairComparisonResults().adjustThresholds();
        GUIController.getConfigurationTopComponent().getPairComparisonResults().getHistogram1().resetSlider();

    }

    private void canvas1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseReleased
        manipulatePoint = false;
        if (selection && SwingUtilities.isLeftMouseButton(evt)) {
            listener1.setSelectionEnd(evt.getPoint(), canvas1.getWidth(), canvas1.getHeight());
            listener1.setSelectionFinished(true);
            final ConfigurationTopComponent tc = GUIController.getConfigurationTopComponent();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    tc.getPairComparisonResults().updateHistograms();
                    tc.getPairComparisonResults().adjustThresholds();
                    tc.getPairComparisonResults().getHistogram1().resetSlider();
                }
            };
            Timer t = new Timer();
            t.schedule(tt, 500);
        }

    }//GEN-LAST:event_canvas1MouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cz.fidentis.gui.Canvas canvas1;
    private cz.fidentis.gui.Canvas canvas2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setPlaneNormal(Vector3f vector3f, boolean recountEverything) {
        listener1.setPlaneNormal(vector3f);
        listener2.setPlaneNormal(vector3f);

        if (listener1.getModels() != null) {
            if (recountEverything) {
                ArrayList<LinkedList<LinkedList<Vector3f>>> lists = new ArrayList<>();

                for (Model m : listener2.getModels()) {
                    lists.add(IntersectionUtils.findModelPlaneIntersection(m, listener1.getPlaneNormal(), listener1.getPlanePoint()));
                }
                listener2.setLists(lists, true);
                listener1.setLists(lists);
            } else {
                ArrayList<LinkedList<LinkedList<Vector3f>>> lists = new ArrayList<>();
                lists.add(IntersectionUtils.findModelPlaneIntersection(listener1.getModels().get(0), listener1.getPlaneNormal(), listener1.getPlanePoint()));
                listener1.setLists(lists);
                listener2.setLists(lists, true);
            }
        }
    }

    @Override
    public void setPlanePoint(Vector3f vector3f, boolean recountEverything) {
        listener1.setPlanePoint(vector3f);
        listener2.setPlanePoint(vector3f);

        if (listener1.getModels() != null) {
            if (recountEverything) {
                ArrayList<LinkedList<LinkedList<Vector3f>>> lists = new ArrayList<>();

                for (Model m : listener2.getModels()) {
                    lists.add(IntersectionUtils.findModelPlaneIntersection(m, listener1.getPlaneNormal(), listener1.getPlanePoint()));
                }
                listener2.setLists(lists, true);
                listener1.setLists(lists);

            } else {
                ArrayList<LinkedList<LinkedList<Vector3f>>> lists = new ArrayList<>();
                lists.add(IntersectionUtils.findModelPlaneIntersection(listener1.getModels().get(0), listener1.getPlaneNormal(), listener1.getPlanePoint()));
                listener1.setLists(lists);
                listener2.setLists(lists, true);
            }
        }
    }

}
