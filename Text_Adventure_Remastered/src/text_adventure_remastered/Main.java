
package text_adventure_remastered;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {

    public static String[][] map = new String[30][30];
    public static String[][] LandMarkMap = new String[30][30];
    public static int x = 15;
    public static int y = 15;
    public static int MaxWater = 30;
    public static int MaxFood = 10;
    public int on = 1;
    public int answer;
     public static BackPack pack = new BackPack(MaxFood,MaxWater,0,0,0,0,0,0,0,0);
    
    public Main() {
        initComponents();
    }
    


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        up = new javax.swing.JToggleButton();
        down = new javax.swing.JToggleButton();
        right = new javax.swing.JToggleButton();
        left = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Materials = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        up.setText("↑");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        down.setText("↓");
        down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });

        right.setText("→");
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        left.setText("←");
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        Output.setEditable(false);
        Output.setColumns(20);
        Output.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        Output.setForeground(new java.awt.Color(102, 0, 204));
        Output.setRows(5);
        jScrollPane1.setViewportView(Output);

        Materials.setEditable(false);
        Materials.setColumns(20);
        Materials.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 12)); // NOI18N
        Materials.setRows(5);
        jScrollPane2.setViewportView(Materials);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            CreateLandmarks();
            CreateMap();
            map[x][y] = " ð ";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_formWindowActivated

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        if (Check(-1, 0) == 1) {
                MovePlayer(-1, 0);
                pack.setWater(pack.getWater()-1);
                CheckFood();
                CreateMap();
                CheckHealth();
                WildernessAttack();
        }
        else if (Check(-1,0) == 2){
                MovePlayer(-1, 0);   
                CreateMap(); 
                CheckHealth();
                pack.setWater(pack.getWater()-1);
                CheckFood();
                runLandmark(LandMarkMap[x][y]);
        }
        
    }//GEN-LAST:event_upActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        
        if( Check(1,0) == 1 ){
                MovePlayer(1, 0);
                pack.setWater(pack.getWater()-1);
                CheckFood();
                CreateMap();  
                CheckHealth();
                WildernessAttack();
        }
        else if ( Check(1,0) == 2){
                MovePlayer(1, 0);
                pack.setWater(pack.getWater()-1);
                CheckFood();
                CreateMap();
                CheckHealth();
                runLandmark(LandMarkMap[x][y]);
        }
        
        
    }//GEN-LAST:event_downActionPerformed

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
        if( Check(0,-1) == 1 ){
                MovePlayer(0, -1);
                pack.setWater(pack.getWater()-1);
                CheckFood();
                CreateMap();
                CheckHealth();
                WildernessAttack();
        }
        else if ( Check(0,-1) == 2){
                MovePlayer(0, -1); 
                CreateMap(); 
                CheckHealth();
                pack.setWater(pack.getWater()-1);
                CheckFood();
                runLandmark(LandMarkMap[x][y]);
        }
    }//GEN-LAST:event_leftActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        if( Check(0,1) == 1 ){
                MovePlayer(0, 1);
                pack.setWater(pack.getWater()-1);
                CheckFood();
                CreateMap();
                CheckHealth();
                WildernessAttack();
        }
        else if ( Check(0,1) == 2){
                MovePlayer(0, 1);
                pack.setWater(pack.getWater()-1);
                CheckFood();
                CreateMap();
                CheckHealth();
                runLandmark(LandMarkMap[x][y]);
        }
    }//GEN-LAST:event_rightActionPerformed

    
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    
    public void CreateLandmarks() throws FileNotFoundException{
        Random rand = new Random();
        try{
            File dirl = new File("res/template1.txt");
            Scanner read = new Scanner(dirl);
            for (int i = 0; i < 30; i++) {
                String line = read.nextLine();
                String item= null;
                for (int j = 0; j < 30; j++) {
                    switch (line.charAt(j)) {
                        case '#':
                            item = "   ";
                            break;
                        case 'C':
                            item = "|C|";
                            break;
                        case 'H':
                            item = "|H|";
                            break;
                        case 'A':
                            item = " A ";
                            break;
                        case 'O':
                            item = "|O|";
                            break;
                        default:
                            break;
                        }
                    map[i][j]=item;
                    LandMarkMap[i][j]=item;
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    public String newline = "\n";
    public void CreateMap() {
        
        String Food = Integer.toString(pack.getFood());
        String Water = Integer.toString(pack.getWater());
        String Iron = Integer.toString(pack.getIron());
        String Steel = Integer.toString(pack.getSteel());
        String woodenClub = Integer.toString(pack.getWoodenClub());
        String Sword = Integer.toString(pack.getSword());
        String Knife = Integer.toString(pack.getKnife());
        String Leather = Integer.toString(pack.getLeather());
        String Wood = Integer.toString(pack.getWood());
        String Medicine = Integer.toString(pack.medicine);
        
        Materials.setText(null);
        Materials.append("Food: " + Food + newline);
        Materials.append("Water: " + Water + newline);
        
        if(pack.leather > 0){
            Materials.append("Leather: " + Leather + newline);
        }
        if(pack.wood > 0){
            Materials.append("Wood: " + Wood + newline);
        }
        if(pack.iron > 0){
            Materials.append("Iron: " + Iron + newline);
        }
        if(pack.steel > 0){
            Materials.append("Steel: " + Steel + newline);
        }
        if(pack.medicine > 0){
            Materials.append("Medicine: " + Medicine + newline);
        }
        if("1".equals(Sword)){
            Materials.append("Weapon: Sword" + newline);
        }else if ("1".equals(Knife)){
            Materials.append("Weapon: Knife" + newline);
        }else if ("1".equals(woodenClub)){
            Materials.append("Weapon: WoodenClub" + newline);
        }
        
        Output.setText(null);
        
        for (int i = 0; i < 46; i++) {
            Output.append("__");
        }
        Output.append(newline);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30 ; j++) {
                Output.append(map[i][j]);
            }
            Output.append(" |" + newline);
        }
        for (int i = 0; i < 27; i++) {
            Output.append("‾‾‾‾");
        }

        map[x][y] = "[@]";
    }
    
    public int check = 0;
    public void CheckFood(){
        
        if(check == 2){
            pack.food--;
            check = 0;
        }else{
            check++;
        }
    }
    
    public void CheckHealth(){
        if(pack.water == 0){
            Output.append("You've ran out of water" + newline);
            Output.append("It becomes impossible to go on" + newline);
        }else if (pack.water <= -1){
            map[x][y] =" " + "\u2620" + " ";
            CreateMap();
            Output.append("\n");
            Output.append("You ran out of water and have died of thirst" + newline);
            Output.append("\n");
            Output.append("GAME OVER");
            //System.exit(0);
            up.setEnabled(false);
            down.setEnabled(false);
            left.setEnabled(false);
            right.setEnabled(false);
        }else if (pack.food == 0 ){
            Output.append("Youve ran out of food " + newline);
            Output.append("it will only take days to starve" + newline);
        }else if (pack.food < -2){
            map[x][y] =" " + "\u2620" + " ";
            CreateMap();
            Output.append("\n");
            Output.append("You ran out of food and have starved to death" + newline);
            Output.append("\n");
            Output.append("GAME OVER");
            //System.exit(0);
            up.setEnabled(false);
            down.setEnabled(false);
            left.setEnabled(false);
            right.setEnabled(false);
        }
    }
        
    public int Check(int ex, int why) {
        if ((x + ex) < 0 || (x + ex) > 29 || (y + why) < 0 || (y + why) > 29) {
            return -1;
        }else if (!"   ".equals(LandMarkMap[x+ex][y+why])){
            return 2;
        }else {
            return 1;
        }
    }
    
    public void MovePlayer(int ex, int why) {
        map[x][y] = LandMarkMap[x][y];

        x += ex;
        y += why;

        
        if(on == 7){
            on = 1;
        }
        
        switch (on) {
            case 1:
                map[x][y]=" ò ";
                on++;
                break;
            case 2:
                map[x][y]=" ó ";
                on++;
                break;
            case 3:
                map[x][y]=" ô ";
                on++;
                break;
            case 4:
                map[x][y]=" õ ";
                on++;
                break;
            case 5:
                map[x][y]=" ö ";
                on++;
                break;
            case 6:
                map[x][y]=" ð ";
                on++;
                break;
            default:
                break;
        }
        
    }
    
        public void WildernessAttack(){
        
        
        //giving a 20% chance of getting attacked every time you make a step
        //type 1
        if(x >= 10 && x <= 20 && y >= 10 && y <= 20){
            GenerateAttack(20,0,"W");
        }
        //type 2 
        if ( (x > 5 && x < 10) && (y > 5  && y < 25) ){
            GenerateAttack(20,3,"W");
        }
        if( x > 20 && x < 25 && (y > 5  && y < 25)){
            GenerateAttack(20,3,"W");
        }
        if(y > 5 && y < 10 && (x > 5 && x < 25) ){
            GenerateAttack(20,3,"W");
        }
        if(y > 20 && y < 25 && (x > 5 && x < 25) ){
            GenerateAttack(20,3,"W");
        }
        //type 2 
        
        //type 3
        if(x >= 0 && x <= 5 && y >= 0 && y < 30 ){
            GenerateAttack(20,5,"W");
        }        
        if(x >= 25 && x < 30 && y >= 0 && y < 30){
            GenerateAttack(20,5,"W");
        }        
        if (y >= 0 && y <= 5 && x >= 0 && x < 30 ){
            GenerateAttack(20,5,"W");
        }        
        if(y >= 25 & y < 30 && x >= 0 && x < 30){
            GenerateAttack(20,5,"W");
        }
        //type 3 
    }
        
    public void GenerateAttack(int chance, int difficulty, String type)  {
        // the number is the paramater that the number out of 100 needs to meet
        // e.g. chance = 2 means that the number needs to be 2 or lower (or 2% chance or getting attacked)
        // in order for the attacksequence to run 

        Random rand = new Random();
        int isAttack = rand.nextInt(100);
        isAttack++;
        if(isAttack <= chance){
            AttackSequence(difficulty,type);
        }
    }
        public void AttackSequence(int difficulty, String type){
       // 0 = type 1 wilderness
       // 1 = type 1 cave or house  
       // 2 = type 2 cave or house 
       // 3 = type 2 wilderness
       // 4 = type 3 cave or house
       // 5 = type 3 wilderness
       // 6 = City 

        Output.append(newline + "You've been attacked but you won by default because i havent finished this yet");
       
    }
        
    public void runLandmark(String entity){
        //checking where the landmark is on the map
        int type =0;
        
        //dont try to judge this was the only way i could carefully do it without making mistakes
        
        //type 1
        if(x >= 10 && x <= 20 && y >= 10 && y <= 20){
            type = 1;
        }
        //type 2 
        if ( (x > 5 && x < 10) && (y > 5  && y < 25) ){
            type = 2;
        }
        if( x > 20 && x < 25 && (y > 5  && y < 25)){
            type = 2;
        }
        if(y > 5 && y < 10 && (x > 5 && x < 25) ){
            type =2;
        }
        if(y > 20 && y < 25 && (x > 5 && x < 25) ){
            type =2;
        }
        //type 2 
        
        //type 3
        if(x >= 0 && x <= 5 && y >= 0 && y < 30 ){
            type = 3;
        }        
        if(x >= 25 && x < 30 && y >= 0 && y < 30){
            type = 3;
        }        
        if (y >= 0 && y <= 5 && x >= 0 && x < 30 ){
            type = 3;
        }        
        if(y >= 25 & y < 30 && x >= 0 && x < 30){
            type =3;
        }
        //type 3

        switch (entity){
            case "|C|":
                Cave(type);
                break;
            case "|H|":
                House(type);
                break;
            case "|O|":
                City();
                break;
            case" A ":
                Home();
                break;
            case " C ":
                System.out.println("This cave has already been explored");
                break;
            case " H ":
                System.out.println("This house has already been explored");
                break;
            default:
                System.out.println("lmao youll never see this ☻");
        }
    }
    public void Home(){
        Output.append(newline + "You are in your home");
    }
    
    public void Cave(int type){
        Output.append(newline + "You are in a cave");
    }
    
    public void House(int type){
        Output.append(newline + "You are in a house");
    }
    
    public void City(){
        Output.append(newline + "You are in a city");
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Materials;
    private javax.swing.JTextArea Output;
    private javax.swing.JToggleButton down;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton left;
    private javax.swing.JToggleButton right;
    private javax.swing.JToggleButton up;
    // End of variables declaration//GEN-END:variables
}
