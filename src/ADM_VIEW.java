
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class ADM_VIEW extends javax.swing.JFrame {

    public ADM_VIEW() {
        initComponents();
        populateTable();
    }
    void populateTable()
    {
        try
        {
            String qry="select count(*)NOR from tbbook";
            ResultSet rs=new DB().execute(qry);
            rs.next();
            int rows=rs.getInt("NOR");
            String data[][]=new String[rows][7];
            qry="select booktit,bookauth,bookpub,bookprc,bookcopies,bookstackno,bookissued from tbbook";
            rs=new DB().execute(qry);
            int i=0,j=0;
            while(rs.next())
            {
                data[i][j++]=rs.getString("booktit");
                data[i][j++]=rs.getString("bookauth");
                data[i][j++]=rs.getString("bookpub");
                data[i][j++]=rs.getString("bookprc");
                data[i][j++]=rs.getString("bookcopies");
                data[i][j++]=rs.getString("bookstackno");
                data[i][j++]=rs.getString("bookissued");
                j=0;
                i++;
            }
            String cols[]={"Title","Author","Publisher","Price","Copies","Stack ID","Issued"};
            DefaultTableModel dtm=new DefaultTableModel(data,cols);
            jTable1.setModel(dtm);
            this.pack();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin View All Books");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
