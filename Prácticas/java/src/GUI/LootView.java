/**
 *
 * @author elena
 */

package GUI;
import deepspace.LootToUI;

public class LootView extends javax.swing.JPanel {
 
    public LootView() {
        initComponents();
    }
    
    void setLoot(LootToUI l){
        n_armas.setText(Integer.toString(l.getnWeapons())); 
        n_escudos.setText(Integer.toString(l.getnShields()));
        nMedals.setText(Integer.toString(l.getnMedals()));
        n_hangars.setText(Integer.toString(l.getnHangars()));
        n_supplies.setText(Integer.toString(l.getnSupplies()));
        
        transform.setVisible(true);
        if(l.isSpaceCity())
            transform.setText("Ciudad Espacial");
        else if (l.isGetEfficient())
            transform.setText("Estación Eficiente");
        else
            transform.setVisible(false);
        
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        armas_label = new javax.swing.JLabel();
        escudos_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combustible_jl = new javax.swing.JLabel();
        medallas_jl = new javax.swing.JLabel();
        n_supplies = new javax.swing.JLabel();
        n_escudos = new javax.swing.JLabel();
        n_armas = new javax.swing.JLabel();
        n_hangars = new javax.swing.JLabel();
        nMedals = new javax.swing.JLabel();
        transform = new javax.swing.JLabel();

        armas_label.setText("Armas:");

        escudos_label.setText("Escudos: ");

        jLabel1.setText("Provisiones:");

        combustible_jl.setText("Hangares: ");

        medallas_jl.setText("Medallas: ");

        n_supplies.setText("jLabel2");

        n_escudos.setText("jLabel3");

        n_armas.setText("jLabel4");

        n_hangars.setText("jLabel5");

        nMedals.setText("jLabel6");

        transform.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(escudos_label)
                    .addComponent(armas_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(n_escudos)
                            .addComponent(n_armas, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combustible_jl)
                            .addComponent(medallas_jl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nMedals)
                            .addComponent(n_hangars)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(n_supplies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transform)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(armas_label)
                    .addComponent(combustible_jl)
                    .addComponent(n_armas)
                    .addComponent(n_hangars))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(escudos_label)
                    .addComponent(medallas_jl)
                    .addComponent(n_escudos)
                    .addComponent(nMedals))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(n_supplies)
                    .addComponent(transform))
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel armas_label;
    private javax.swing.JLabel combustible_jl;
    private javax.swing.JLabel escudos_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel medallas_jl;
    private javax.swing.JLabel nMedals;
    private javax.swing.JLabel n_armas;
    private javax.swing.JLabel n_escudos;
    private javax.swing.JLabel n_hangars;
    private javax.swing.JLabel n_supplies;
    private javax.swing.JLabel transform;
    // End of variables declaration//GEN-END:variables
}
