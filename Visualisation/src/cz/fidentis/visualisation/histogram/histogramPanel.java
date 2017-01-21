/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.visualisation.histogram;

import cz.fidentis.visualisation.ColorScheme;
import cz.fidentis.visualisation.ColorSelector;
import cz.fidentis.visualisation.surfaceComparison.HDpainting;
import cz.fidentis.visualisation.surfaceComparison.HDpaintingInfo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.vecmath.Vector4f;

/**
 *
 * @author Katka
 */
public class histogramPanel extends JComponent {

    private List<Float> values;// = new float[50][50];
    private List<Float> vl = new ArrayList<Float>();
    private Vector4f activeArea = new Vector4f();
    private Point slider1Tip;
    private boolean slider1Selected = false;
    private Point slider2Tip;
    private boolean slider2Selected = false;
    private float slider2X;
    private float slider1X;
    private float mouseX;
    private float minValue = 0;
    private float maxValue = 0;

    private int width = 100;
    private int height = 100;

    /**
     * Creates new form plotsPanel
     */
    public histogramPanel() {
        initComponents();
        slider1Tip = new Point(this.getWidth() - 5, 5);
        slider2Tip = new Point(5, 5);

    }

    private HDpaintingInfo hdp;

    public void setHdp(HDpaintingInfo hdp) {
        this.hdp = hdp;
    }

    public List<Float> getValues() {
        return values;
    }

    public void setValues(List<Float> values) {
        this.vl = new ArrayList<>(values);
        this.values = new ArrayList<>(values);
        recomputeSliderPosition();
        this.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(150, 70));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(150, 70));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

        width = this.getWidth();
        height = this.getHeight();
        recomputeSliderPosition();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_formComponentResized

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        if (Math.abs(evt.getX() - slider1Tip.x) < 3 && (evt.getY() < (height - 60))) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));

        } else if (Math.abs(evt.getX() - slider2Tip.x) < 3 && (evt.getY() < (height - 60))) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));

        } else {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        }
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_formMouseMoved

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (Math.abs(evt.getX() - slider1Tip.x) < 3 && (evt.getY() < (height - 60))) {
            slider1Selected = true;
            slider1X = slider1Tip.x;
            mouseX = evt.getX();
        }
        if (Math.abs(evt.getX() - slider2Tip.x) < 3 && (evt.getY() < (height - 60))) {
            slider2Selected = true;
            slider2X = slider2Tip.x;
            mouseX = evt.getX();
        }

    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        slider1Selected = false;
        slider2Selected = false;
        hdp.setMaxThreshValue(minValue + ((slider1Tip.x - 5) / (float) (this.getWidth() - 10)) * (maxValue - minValue));
        hdp.setMinThreshValue(minValue + ((slider2Tip.x - 5) / (float) (this.getWidth() - 10)) * (maxValue - minValue));
        this.revalidate();
        this.repaint();

    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (slider1Selected) {

            if (slider1X + (evt.getX() - mouseX) < (width - 5) && slider1X + (evt.getX() - mouseX) > 5) {
                slider1Tip.setLocation(slider1X + (evt.getX() - mouseX), slider1Tip.y);
            } else if (slider1X + (evt.getX() - mouseX) > width - 5) {
                slider1Tip.setLocation(width - 5, slider1Tip.y);
            } else {
                slider1Tip.setLocation(5, slider1Tip.y);
            }
            hdp.setMaxThreshValue(minValue + ((slider1Tip.x - 5) / (float) (this.getWidth() - 10)) * (maxValue - minValue));
           

        }
        if (slider2Selected) {

            if (slider2X + (evt.getX() - mouseX) < (width - 5) && slider2X + (evt.getX() - mouseX) > 5) {
                slider2Tip.setLocation(slider2X + (evt.getX() - mouseX), slider2Tip.y);
            } else if (slider2X + (evt.getX() - mouseX) > width - 5) {
                slider2Tip.setLocation(width - 5, slider2Tip.y);
            } else {
                slider2Tip.setLocation(5, slider2Tip.y);
            }
             hdp.setMinThreshValue(minValue + ((slider2Tip.x - 5) / (float) (this.getWidth() - 10)) * (maxValue - minValue));


        }
        
        this.revalidate();
        this.repaint();

    }//GEN-LAST:event_formMouseDragged

    //@Override
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.WHITE);
        //   g2.fill(new Rectangle2D.Double(0, 0, width, height));
        if (values != null && hdp != null) {
            int numValues = values.size();

            maxValue = Float.MIN_VALUE;
            float maxThreshValue = hdp.getMaxThreshValue();//Float.MIN_VALUE;
            float minThreshValue = hdp.getMinThreshValue();
            minValue = Float.MAX_VALUE;

            if (!(hdp.isIsSelection() && !hdp.getSelectionVertices().isEmpty())) {
                for (int i = 0; i < numValues; i++) {
                    if (values.get(i) > maxValue) {
                        maxValue = values.get(i);
                    }
                    if (values.get(i) <= hdp.getMaxDistance()) {

                        if (values.get(i) > maxThreshValue) {
                            maxThreshValue = values.get(i);
                        }
                         if (values.get(i) <minThreshValue) {
                            minThreshValue = values.get(i);
                        }
                        
                        if (values.get(i) < minValue) {
                            minValue = values.get(i);
                        }
                    }
                }
            } else {
                minValue = hdp.getMinSelection();
                maxValue = hdp.getMaxSelection();
            }
            float ratio = (maxThreshValue - minThreshValue) / (maxValue - minValue);
            paintScale(g2, ratio);
        }
    }

    private void paintScale(Graphics2D g2, float ratio) {
        g2.setPaint(Color.BLACK);
        g2.draw(new Line2D.Float(5, height - 60, width - 5, height - 60));
        float stepWidth = 1;
        float step = (maxValue - minValue) / ((float) (width - 10) / stepWidth);

        float[] boundaries = new float[(width - 10) + 1];
        int[] histogram = new int[(width - 10)];

        for (int i = 0; i <= (width - 10) / stepWidth; i++) {
            float v = minValue + i * step;
            boundaries[i] = v;
        }

        int scaleSteps = 5;
        float scaleStepNum = (maxValue - minValue) / (float) scaleSteps;
        for (int i = 0; i <= scaleSteps; i++) {
            float wd = i * ((width - 10) / (float) scaleSteps);
            g2.setPaint(Color.BLACK);
            g2.draw(new Line2D.Float(5 + wd, height - 50, 5 + wd, height - 60));
            Font f = new Font(g2.getFont().getFamily(), Font.PLAIN, 12);
            g2.setFont(f);
            FontMetrics fm = getFontMetrics(getFont());
            float h = fm.getHeight();
            float n = Math.round((minValue + i * scaleStepNum) * 1000f) / 1000f;
            float w = fm.stringWidth(Float.toString(n));

            AffineTransform at = g2.getTransform();//new AffineTransform();
            g2.rotate(-Math.PI / 2f);
            // g2.setTransform(at);
            g2.drawString(Float.toString(n), -1 * (height - 48) - w, (5 + wd) + h / 3);

            //    g2.drawString(Float.toString(n), wd-3,  height - 25);
            //  at.rotate(Math.PI / 2f);
            g2.setTransform(at);
        }

        int numValues = values.size() - 1;
        for (int i = 0; i < numValues; i++) {
            for (int k = 0; k < (width - 10) / stepWidth; k++) {
                if (values.get(i) > boundaries[k] && values.get(i) <= boundaries[k + 1]) {
                    if ((hdp.isIsSelection() && hdp.getSelectionVertices().contains(i)) || (!hdp.isIsSelection())) {
                        histogram[k]++;
                    }
                }
            }
        }

        int maximum = 0;
        for (int k = 0; k < (width - 10) / stepWidth; k++) {
            if (histogram[k] > maximum) {
                maximum = histogram[k];
            }
        }
        float heightStep = (height - 70) / (float) maximum;
        ColorSelector s = new ColorSelector();
        for (int i = 0; i <= (width - 10) / stepWidth; i++) {
            if (i < (width - 10)) {
                Color c1;
                Color c2;
                if (5 + (i * stepWidth) <= slider1Tip.x && 5 + (i * stepWidth)>= slider2Tip.x) {
                    c1 = s.chooseColor(slider2Tip.x - 5, slider1Tip.x - 5, (i * stepWidth), hdp.getColorScheme());
                    c2 = s.chooseColor(slider2Tip.x - 5, slider1Tip.x - 5, ((i + 1) * stepWidth), hdp.getColorScheme());
                    //  c1 =new Color(ColorSpace.getInstance(ColorSpace.CS_sRGB), hdp.chooseColorHSVMapping((i * stepWidth),slider1Tip.x-5, 0), 1);
                    //   c2 =new Color(ColorSpace.getInstance(ColorSpace.CS_sRGB), hdp.chooseColorHSVMapping(((i + 1) * stepWidth), slider1Tip.x-5, 0), 1);
                } else {
                    c1 = new Color(170, 170, 170);
                    c2 = new Color(170, 170, 170);
                }
                int ht = (int) (histogram[i] * heightStep);
                GradientPaint gp = new GradientPaint(5 + (i * stepWidth), 0, c1, 5 + ((i + 1) * stepWidth), 0, c2);
                g2.setPaint(gp);
                g2.fill(new Rectangle2D.Double(5 + (i * stepWidth), height - 60 - ht, stepWidth + (i == (width - 10) - 1 ? 1 : 0), ht));
            }

        }

        paintSlider(g2, slider1Tip);
        paintSlider(g2, slider2Tip);

    }

    private void paintSlider(Graphics2D g2, Point sliderTip) {
        g2.setPaint(Color.BLACK);

        int xPoints[] = {(int) sliderTip.x - 1, (int) sliderTip.x - 4, (int) sliderTip.x + 3, sliderTip.x};
        int yPoints[] = {(int) sliderTip.y, (int) sliderTip.y - 5, (int) sliderTip.y - 5, (int) sliderTip.y};

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.fill(new Polygon(xPoints, yPoints, 4));
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Line2D.Float(sliderTip.x - 1, sliderTip.y, sliderTip.x - 1, height - 61));
        g2.setStroke(new BasicStroke(1));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void resetSlider() {
        slider1Tip = new Point(this.getWidth() - 5, 5);
        slider2Tip = new Point(5, 5);
    }

    public void recomputeSliderPosition() {
        if (hdp == null) {
            return;
        }
        
        if (hdp.getMaxThreshValue() == Float.POSITIVE_INFINITY) {
            slider1Tip = new Point(this.getWidth() - 5, 5);
        } else {
            float thresh = hdp.getMaxThreshValue();
            slider1Tip.setLocation(5 + ((thresh - minValue) / (maxValue - minValue)) * (this.width - 10), slider1Tip.y);
        }
        
        if (hdp.getMinThreshValue() == Float.NEGATIVE_INFINITY) {
            slider2Tip = new Point(5, 5);
        } else {
            float thresh = hdp.getMinThreshValue();
            slider2Tip.setLocation(5 + ((thresh - minValue) / (maxValue - minValue)) * (this.width - 10), slider2Tip.y);
        }
        if(slider2Tip.x<5){
            slider2Tip.x=5;            
        }
        if(slider1Tip.x>this.getWidth() - 5){
            slider2Tip.x=this.getWidth() - 5;            
        }
        
        
    }

    public boolean isMaxSliderSelected() {
        return slider1Selected;
    }

    public boolean isMinSliderSelected() {
        return slider2Selected;
    }
    
    

}
