пакет  rmi ;


import  java.awt.event.ActionEvent ;
import  java.awt.event.ActionListener ;
import  java.text.SimpleDateFormat ;
импорт  java.util.Date ;

Открытый  класс  CClientRMI  расширяет  javax.swing . JFrame {
    приватная  статическая  final  String  DEFAULT_HOST  =  " localhost " ;
    приватная  статическая  final  int  DEFAULT_PORT  =  4321 ;

    приватный  строковый хост =  DEFAULT_HOST ;
    закрытый  int port =  DEFAULT_PORT ;
    частная  Дата дата;
    private  SimpleDateFormat simpleDateFormat =  new  SimpleDateFormat ( " чч: мм: сс:   " );
    приватная  тема showResponseThread;

    частный  RemoteHendlerRMI remoteHendlerRMI;

    public  CClientRMI () {
        супер ( " CClientRMI " );
        initComponents ();
        setResizable ( false );

        remoteHendlerRMI =  новый  RemoteHendlerRMI ( DEFAULT_HOST , DEFAULT_PORT );
        jButton1 . setEnabled ( true );
        jButton2 . setEnabled ( false );

        jButton1 . addActionListener ( новый  ActionListener () {
            @Override
            public  void  actionPerformed ( ActionEvent  e ) {
                // подключаемся к серверу
                remoteHendlerRMI . setHostname (jTextField1 . getText ());
                remoteHendlerRMI . setPort ( Integer . parseInt (jTextField3 . getText ()));

                if (remoteHendlerRMI . getRegistry () ==  null ) {
                    if (remoteHendlerRMI . registClient ()) {
                        jButton1 . setEnabled ( false );
                        jButton2 . setEnabled ( true );
                        showResponse ();
                        jTextArea1 . append (simpleDateFormat . format ( new  Date ()) +  " Подключено к серверу! \ n " );
                    } еще {
                        jTextArea1 . append (simpleDateFormat . format ( new  Date ()) +  " Не удается подключиться к серверу! \ n " );
                    }
                } еще {
                    jTextArea1 . append (simpleDateFormat . format ( new  Date ()) +  "Не удается подключиться к серверу, подключение уже выполнено! \ n " );
                    возврат ;
                }
            }
        });

        jButton2 . addActionListener ( новый  ActionListener () {
            @Override
            public  void  actionPerformed ( ActionEvent  e ) {

                if (remoteHendlerRMI . getRegistry () ! =  null ) {
                    remoteHendlerRMI . близко();
                    jTextArea1 . append (simpleDateFormat . format ( new  Date ()) +  " Disconnected! \ n " );
                    jButton1 . setEnabled ( true );
                    jButton2 . setEnabled ( false );
                } еще {
                    jTextArea1 . append (simpleDateFormat . format ( new  Date ()) +  " Вы уже отключены! \ n " );
                }
            }
        });

        jButton3 . addActionListener ( новый  ActionListener () {
            @Override
            public  void  actionPerformed ( ActionEvent  e ) {
                // отправить сообщение
                if (remoteHendlerRMI . getRegistry () ==  null ) {
                    jTextArea1 . append (simpleDateFormat . format ( new  Date ()) +  " Нет связи с сервером "  +  " \ n " );
                    возврат ;
                }

                if (remoteHendlerRMI . getRegistry () ! =  null ) {
                    remoteHendlerRMI . commandExecute (jTextField2 . getText ());
                    jTextArea1 . append (simpleDateFormat . format ( new  Date ()) + jTextField2 . getText () +  " \ n " );
                }
            }
        });
    }

    приватный  синхронизированный  void  showResponse () {
        showResponseThread =  new  Thread (() - > {
            while (remoteHendlerRMI . getRegistry () ! =  null ) {
                попытаться {
                    Thread . сон ( 50 );
                } catch ( InterruptedException e) {
                    эл . printStackTrace ();
                }
                if (remoteHendlerRMI . getResponseInfo () ! =  null  &&  ! remoteHendlerRMI . getResponseInfo () . equals ( " " )) {
                    jTextArea1 . append (simpleDateFormat . format ( new  Date ()) + remoteHendlerRMI . getResponseInfo () +  " \ n " );
                    remoteHendlerRMI . setResponseInfo ( null );
                }
            }
            jButton1 . setEnabled ( true );
            jButton2 . setEnabled ( false );
        });
        showResponseThread . Начните();
    }

    @SuppressWarnings ( " не проверено " )
    // <editor-fold defaultstate = "collapsed" desc = "Сгенерированный код"> // GEN-BEGIN: initComponents
    private  void  initComponents () {

        jTextField1 =  новый  javax.swing . JTextField ();
        jLabel1 =  новый  javax.swing . JLabel ();
        jTextField3 =  новый  javax.swing . JTextField ();

        jLabel3 =  новый  javax.swing . JLabel ();
        jButton1 =  новый  javax.swing . JButton ();
        jButton2 =  новый  javax.swing . JButton ();
        jScrollPane1 =  новый  javax.swing . JScrollPane ();
        jTextArea1 =  новый  javax.swing . JTextArea ();
        jTextField2 =  новый  javax.swing . JTextField ();
        jButton3 =  новый  javax.swing . JButton ();

        jTextArea1 . setEditable ( false );

        setDefaultCloseOperation ( javax.swing . WindowConstants . EXIT_ON_CLOSE );

        jTextField1 . setText ( " localhost " );

        jLabel1 . setText ( « Адрес » );

        jTextField3 . setText ( " 4321 " );

        jLabel3 . setText ( " Порт " );

        jButton1 . setText ( « Соединить » );

        jButton2 . setText ( " Disconect " );

        jTextArea1 . setColumns ( 20 );
        jTextArea1 . setRows ( 5 );
        jScrollPane1 . setViewportView (jTextArea1);

        jTextField2 . setText ( " #pr: rF: \\ TestSort \\ random.txt sF: \\ TestSort \\ sort.txt; " );

        jButton3 . setText ( « Отправить » );

        javax.swing . Макет GroupLayout =  новый  javax.swing . GroupLayout (getContentPane ());
        getContentPane () . setLayout (макет);
        макет . setHorizontalGroup (
                макет . createParallelGroup ( javax.swing . GroupLayout . Выравнивание . LEADING )
                        .addComponent (jScrollPane1)
                        .addGroup (layout . createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Выравнивание . LEADING )
                                        .addGroup (layout . createSequentialGroup ()
                                                .addComponent (jTextField2)
                                                .addGap ( 18 , 18 , 18 )
                                                .addComponent (jButton3))
                                        .addGroup (layout . createSequentialGroup ()
                                                .addComponent (jLabel1)
                                                .addGap ( 28 , 28 , 28 )
                                                .addComponent (jTextField1, javax.swing . GroupLayout . PREFERRED_SIZE , 158 , javax.swing . GroupLayout . PREFERRED_SIZE )
                                                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELATED , javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE )
                                                .addComponent (jLabel3)
                                                .addGap ( 28 , 28 , 28 )
                                                .addComponent (jTextField3, javax.swing . GroupLayout . PREFERRED_SIZE , 158 , javax.swing . GroupLayout . PREFERRED_SIZE )
                                                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELATED , javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE )
                                                .addComponent (jButton1)
                                                .addGap ( 18 , 18 , 18 )
                                                .addComponent (jButton2)))
                                .addContainerGap ())
        );
        макет . setVerticalGroup (
                макет . createParallelGroup ( javax.swing . GroupLayout . Выравнивание . LEADING )
                        .addGroup ( javax.swing . GroupLayout . Выравнивание . TRAILING , макет . createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (макет . createParallelGroup ( javax.swing . GroupLayout . Выравнивание . BASELINE )
                                        .addComponent (jLabel1)
                                        .addComponent (jTextField1, javax.swing . GroupLayout . PREFERRED_SIZE , javax.swing . GroupLayout . DEFAULT_SIZE , javax.swing . GroupLayout . PREFERRED_SIZE )
                                        .addComponent (jLabel3)
                                        .addComponent (jTextField3, javax.swing . GroupLayout . PREFERRED_SIZE , javax.swing . GroupLayout . DEFAULT_SIZE , javax.swing . GroupLayout . PREFERRED_SIZE )
                                        .addComponent (jButton1)
                                        .addComponent (jButton2))
                                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELATED )
                                .addComponent (jScrollPane1, javax.swing . GroupLayout . PREFERRED_SIZE , 311 , javax.swing . GroupLayout . PREFERRED_SIZE )
                                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . UNRELATED )
                                .addGroup (макет . createParallelGroup ( javax.swing . GroupLayout . Выравнивание . BASELINE )
                                        .addComponent (jTextField2, javax.swing . GroupLayout . PREFERRED_SIZE , javax.swing . GroupLayout . DEFAULT_SIZE , javax.swing . GroupLayout . PREFERRED_SIZE )
                                        .addComponent (jButton3))
                                .addContainerGap ( javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE ))
        );

        упаковка ();
    } // </ editor-fold> // GEN-END: initComponents

    public  static  void  main ( String  args []) {
        / * Установить внешний вид Nimbus * /
        // <editor-fold defaultstate = "collapsed" desc = "Внешний вид и код настройки (необязательно)">
        / * Если Nimbus (представлен в Java SE 6) недоступен, оставайтесь с настройками по умолчанию.
         * Подробнее см. Http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html.
         * /
        попытаться {
            for ( javax.swing . UIManager . Информация LookAndFeelInfo :  javax.swing . UIManager . getInstalledLookAndFeels ()) {
                if ( " Nimbus " . равно (info . getName ())) {
                    javax.swing . UIManager . setLookAndFeel (info . getClassName ());
                    перерыв ;
                }
            }
        } catch ( ClassNotFoundException ex) {
            java.util.logging . Logger . getLogger ( CClientRMI . class . getName ()) . log ( java.util.logging . Level . SEVERE , null , ex);
        } catch ( InstantiationException ex) {
            java.util.logging . Logger . getLogger ( CClientRMI . class . getName ()) . log ( java.util.logging . Level . SEVERE , null , ex);
        } catch ( IllegalAccessException ex) {
            java.util.logging . Logger . getLogger ( CClientRMI . class . getName ()) . log ( java.util.logging . Level . SEVERE , null , ex);
        } catch ( javax.swing . UnsupportedLookAndFeelException ex) {
            java.util.logging . Logger . getLogger ( CClientRMI . class . getName ()) . log ( java.util.logging . Level . SEVERE , null , ex);
        }
        // </ editor-fold>

        / * Создать и отобразить форму * /
        java.awt . EventQueue . invokeLater ( new  Runnable () {
            public  void  run () {
                новый  CClientRMI () . setVisible ( true );

            }
        });
    }

    // Объявление переменных - не изменять // GEN-BEGIN: переменные
    частный  javax.swing . JButton jButton1;
    частный  javax.swing . JButton jButton2;
    частный  javax.swing . JButton jButton3;
    частный  javax.swing . JLabel jLabel1;
    частный  javax.swing . JLabel jLabel3;
    частный  javax.swing . JScrollPane jScrollPane1;
    частный  javax.swing . JTextArea jTextArea1;
    частный  javax.swing . JTextField jTextField1;
    частный  javax.swing . JTextField jTextField2;
    частный  javax.swing . JTextField jTextField3;

    // ConsoleBuffer Java lib
    // Конец объявления переменных // GEN-END: переменные
}
