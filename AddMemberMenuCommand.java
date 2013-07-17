/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : AddMemberMenuCommand.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
public class AddMemberMenuCommand implements Command
{
    //Command DP: ConcreteCommand
    private Member member;

    public AddMemberMenuCommand(Member mem)
    {
        this.member = mem;
    }

    public void execute()
    {
        member.addMember();
    }
}