/**
 *
 * @author elena
 */

package View;

import java.util.ArrayList;
import java.awt.Component;

import deepspace.HangarToUI;
import deepspace.WeaponToUI;
import deepspace.ShieldToUI;

public class HangarView extends javax.swing.JPanel {
    /**
     * Creates new form HangarView
     */
    HangarView() {
        initComponents();
    }
    
    void setHangarView(HangarToUI h){
        String title= "Hangar con capacidad " + Integer.toString(h.getMaxElements());
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), title));
        jPanel2.removeAll();
        WeaponView v;
        ShieldBoosterView s;
        
        for(WeaponToUI w: h.getWeapons()){
            v= new WeaponView();
            v.setWeapon(w);
            jPanel2.add(v);
        }
        
        for(ShieldToUI sh: h.getShieldBoosters()){
            s= new ShieldBoosterView();
            s.setShieldBooster(sh);
            jPanel2.add(s);
        }
        
        repaint();
        revalidate();
       
    }
    
    public ArrayList<Integer> getHangarItems(){
        ArrayList<Integer> items = new ArrayList();
        int i = 0;
        for(Component c : jPanel2.getComponents()){
            if(((CombatElementView) c).isSelected()){    //Averiguar si es weaponView o shieldView
                items.add(i);
            }
            i++;
        }
        return items;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hangar"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
