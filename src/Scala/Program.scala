package Scala

import java.awt.BorderLayout
import java.awt.event._
import javax.swing._

/**
  * Created by B-40 on 25-4-2017.
  */
object Program{
  //Construct method
  def Init():Unit = {
    val frame: JFrame = new JFrame("SocketServer")
    val panelHolder: JPanel = new JPanel()
    val statusLabel: JLabel = new JLabel("Server is down", SwingConstants.CENTER)
    val startButton,stopButton: JButton = new JButton()

    //panels
    panelHolder.setLayout(new BorderLayout())

    //Buttons
    startButton.setText("Start server!")
    startButton.setEnabled(true)
    startButton.addActionListener(new ActionListener()
    {
      def actionPerformed(e: ActionEvent): Unit =
      {
        stopButton.setEnabled(true)
        startButton.setEnabled(false)
        statusLabel.setText(SocketLogic.StartServer())
      }
    })

    stopButton.setText("Stop Server")
    stopButton.setEnabled(false)
    stopButton.addActionListener(new ActionListener()
    {
      def actionPerformed(e: ActionEvent): Unit =
      {
        stopButton.setEnabled(false)
        startButton.setEnabled(true)
        statusLabel.setText(SocketLogic.StopServer())
      }
    })

    //Display Frame
    frame.pack()
    frame.setSize(500,150)
    frame.setLocationRelativeTo(null)
    frame.setResizable(false)

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setVisible(true)

    //Add all to panel
    frame.add(panelHolder)
    panelHolder.add(statusLabel, BorderLayout.CENTER)
    panelHolder.add(startButton, BorderLayout.WEST)
    panelHolder.add(stopButton, BorderLayout.EAST)
  }
}
