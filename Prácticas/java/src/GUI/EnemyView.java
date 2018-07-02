/**
 *
 * @author elena
 */

package GUI;

import deepspace.EnemyToUI;
import deepspace.LootToUI;
import deepspace.DamageToUI;


public class EnemyView extends javax.swing.JPanel {
    public EnemyView() {
        initComponents();
    }
    
    void setEnemy(EnemyToUI e){
        enemy_name.setText(e.getName());
        ammoPower.setText(Float.toString(e.getAmmoPower())); 
        shieldPower.setText(Float.toString(e.getShieldPower()));
        
        LootView l= new LootView();
        l.setLoot(e.getLoot());
        loot_panel.add(l);
        
        DamageView d= new DamageView();
        d.setDamage(e.getDamage());
        perdidas_panel.add(d);
        
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loot_panel = new javax.swing.JPanel();
        perdidas_panel = new javax.swing.JPanel();
        enemy_name = new javax.swing.JLabel();
        ammoPower = new javax.swing.JLabel();
        shieldPower = new javax.swing.JLabel();

        jLabel1.setText("Enemigo: ");

        jLabel2.setText("Potencia de fuego: ");

        jLabel3.setText("Potencia de defensa:  ");

        loot_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Botín"));

        perdidas_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pérdidas"));

        enemy_name.setText("jLabel4");

        ammoPower.setText("jLabel4");

        shieldPower.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loot_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemy_name)
                            .addComponent(ammoPower)
                            .addComponent(shieldPower))
                        .addGap(34, 34, 34))
                    .addComponent(perdidas_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(enemy_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ammoPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(shieldPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loot_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(perdidas_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammoPower;
    private javax.swing.JLabel enemy_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel loot_panel;
    private javax.swing.JPanel perdidas_panel;
    private javax.swing.JLabel shieldPower;
    // End of variables declaration//GEN-END:variables
}
