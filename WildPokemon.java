import javax.swing.*;
import java.io.File;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 


public class WildPokemon extends JFrame {
    private Trainer trainer;
    private Pokemon pokemon1 = new Pokemon();
    private Pokemon pokemon2 = new Pokemon();
    private Pokemon pokemon3 = new Pokemon();

    public WildPokemon(Trainer trainer){

        super("Pokemon WildPokemon");
        this.trainer = trainer;

        // Pokemon pokemon1 = new Pokemon();
        // Pokemon pokemon2 = new Pokemon();
        // Pokemon pokemon3 = new Pokemon();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());

        // JLabel[] wildimg = new JLabel[3];
        JLabel wildimg1 = new JLabel();
        JLabel wildimg2 = new JLabel();
        JLabel wildimg3 = new JLabel();
        File[] file = new File[7];
        file[0] = new File("Gardie.jpg");
        file[1] = new File("Hitokage.jpg");
        file[2] = new File("Lepardas.jpg");
        file[3] = new File("Pidgey.jpg");
        file[4] = new File("Miltank.jpg");
        file[5] = new File("Lucario.jpg");
        file[6] = new File("Dewgong.jpg");
    
        BufferedImage[] img = new BufferedImage[7]; 
    
        System.out.println("+++");
        for(int i=0; i<7; i++){
            try{
                img[i] = ImageIO.read(file[i]);
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }   
        }
    


        JButton[] wildbotton = new JButton[3];
        JLabel[] wildtext = new JLabel[3];
        Random rand = new Random();
    
    
        for(int i=0; i<3;i++){
            int level = rand.nextInt(10);
            int wildpoke = rand.nextInt(7);

            if(i == 0){
                pokemon1.poke(wildpoke,level+1);
                wildimg1.setIcon(new ImageIcon(img[wildpoke]));
                wildtext[0] = new JLabel("wild "+pokemon1.getnameP()+"  level : " + pokemon1.getlevel()+"  HP : "+pokemon1.getHP()+" ");
                wildbotton[0] = new JButton("Battle");
                wildbotton[0].setBackground ( Color.gray );
                wildbotton[0].setForeground ( Color.black);   
            
            }
            else if(i == 1){
                pokemon2.poke(wildpoke,level+1);
                wildimg2.setIcon(new ImageIcon(img[wildpoke]));
                wildtext[1] = new JLabel("wild "+pokemon2.getnameP()+"  level : " + pokemon2.getlevel()+"  HP : "+pokemon2.getHP()+" ");
                wildbotton[1] = new JButton("Battle");
                wildbotton[1].setBackground ( Color.gray );
                wildbotton[1].setForeground ( Color.black);   
            }
            else if(i == 2){
                pokemon3.poke(wildpoke,level+1);
                wildimg3.setIcon(new ImageIcon(img[wildpoke]));
                wildtext[2] = new JLabel("wild "+pokemon3.getnameP()+"  level : " + pokemon3.getlevel()+"  HP : "+pokemon3.getHP()+" ");
                wildbotton[2] = new JButton("Battle");
                wildbotton[2].setBackground ( Color.gray );
                wildbotton[2].setForeground ( Color.black);   
            }
        }
    
        Box[] wildbox = new Box[3];
        for(int i=0; i<3; i++){
            wildbox[i] = Box.createVerticalBox();
            if(i==0)
                wildbox[i].add(wildimg1);
            else if(i==1)
                wildbox[i].add(wildimg2);
            else if(i==2)
                wildbox[i].add(wildimg3);
                wildbox[i].add(Box.createVerticalStrut(20));
                wildbox[i].add(wildtext[i]);
                wildbox[i].add(Box.createVerticalStrut(20));
                wildbox[i].add(wildbotton[i]);
            
            addItem(panel1, wildbox[i], i, 0, 1, 1, GridBagConstraints.CENTER);
        }
    

        JButton BlackButton = new JButton("Back");
        BlackButton.setBackground ( Color.gray );
        BlackButton.setForeground ( Color.black);

        // addItem(panel1, wildimg1, 1, 0, 1, 1, GridBagConstraints.CENTER);                                                 
        addItem(panel1, BlackButton, 2, 4, 1, 1, GridBagConstraints.CENTER);


        wildbotton[0].addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                SelectPokemon sp = new SelectPokemon(trainer,pokemon1);
                sp.setVisible(true);
                setVisible(false);
            }
        });

        wildbotton[1].addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                SelectPokemon sp = new SelectPokemon(trainer,pokemon2);
                sp.setVisible(true);
                setVisible(false);
            }
        });

        wildbotton[2].addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                SelectPokemon sp = new SelectPokemon(trainer,pokemon3);
                sp.setVisible(true);
                setVisible(false);
            }   
        });
        
        BlackButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                MainGame maingame = new MainGame(trainer);
                maingame.setVisible(true);
                setVisible(false);
            }   
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
        pack();
        setSize(1000, 600);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setVisible(true);    
    }
    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 256;
        gc.weighty = 256;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.CENTER;
        p.add(c, gc);
    }
}