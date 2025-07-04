import java.util.*;
class ParcelData{
	String stage;
	ParcelData  next;
	String ID;
public ParcelData(String ID,String stage) {
		this.ID = ID;
		this.stage=stage;
	}
}
public class Parcel{
	static ArrayList<ParcelData> dataBase=new ArrayList<>();
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Select Choices below");
			System.out.println("Add a Parcel:1");
			System.out.println("Check if Parcel Have Crossed the given Stage Or not:2");
			System.out.println("Remove a parcel which missed:3");
			System.out.println("check if a parcel Losses/missing:4");
			System.out.println("Check Stage:5");
			System.out.println("Print Data:6");
			System.out.println("Exit:7");
			int choice=sc.nextInt();
			if(choice==1) {
				System.out.print("Add a Parcel With ID :  ");
				String parcelID=sc.next();
				ParcelData head=new ParcelData(parcelID,"Packed");
				dataBase.add(head);
			}
			if(choice==8) {
				System.out.print("Add a Parcel With ID :  ");
				String parcelID=sc.next();
				System.out.print("Add stage");
				String stage=sc.next();
				addStage(parcelID,stage);
			}
			else if(choice==2) {
				System.out.println("Enter ID Of Parcel");
				String ID=sc.next();
				System.out.println("Enter Stage");
				String stage=sc.next();
				interMediateCheckPoint(stage,ID);
			}
			
			else if(choice==3) {
				System.out.println("Enter ID Of Parcel which is missed");
				String ID=sc.next();
				deleteLostParcel(ID);
			}
			else if(choice==4) {
				System.out.println("Enter ID Of Parcel to check if a parcel Losses/missing");
				String ID=sc.next();
				check(ID);
			}
			else if(choice==5) {
				System.out.println("Enter ID Of Parcel");
				String ID=sc.next();
				checkStage(ID);
			}
			else if(choice==7) {
				System.out.println("Exit Success");
				break;
			}
			else if(choice==6) printData();
		}
	}
	public static void addStage(String ID,String stage) {
		ParcelData head=null;
		for(ParcelData pd:dataBase) {
			if(pd.ID.equals(ID)) {
				head=pd;
			}
		}
		if(head==null) {
			System.out.println("Package Lost");
			return;
		}
		ParcelData temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=new ParcelData(ID,stage);
	}
	public static void printData() {
		for(ParcelData pd:dataBase) {
			System.out.println(pd.ID+" "+pd.stage);
		}
	}
	public static void checkStage(String ID) {
		ParcelData head=null;
		for(ParcelData pd:dataBase) {
			if(pd.ID.equals(ID)) {
				head=pd;
			}
		}
		if(head==null) {
			System.out.println("Package Lost");
			return;
		}
		ParcelData temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		System.out.println("Parcel Reached to Stage: "+temp.stage);
		}
	public static void check(String ID) {
		for(int i=0;i<dataBase.size();i++){
			if(dataBase.get(i).ID.equals(ID)) {
				System.out.println("Parcel is not lost");
				return;
			}
		}
		System.out.println("Parcel is lost");
	}
	public static void deleteLostParcel(String ID) {
		for(int i=0;i<dataBase.size();i++){
			if(dataBase.get(i).ID.equals(ID)) {
				dataBase.remove(i);	
				System.out.println("Parcel Have Been Removed");
			}
		}
	}
	public static void interMediateCheckPoint(String stage,String ID) {
		ParcelData head=null;
		for(ParcelData pd:dataBase) {
			if(pd.ID.equals(ID)) {
				head=pd;
			}
		}
		if(head==null) {
			System.out.println("Package Lost");
			return;
		}
		ParcelData temp=head;
		while(temp!=null) {
			if(temp.stage.equals(stage)) {
				System.out.println("Yes Parcel is reached or cross the given stage"+stage);
				return;
			}
			temp=temp.next;
		}
		System.out.println("No Order is not reached the stage"+stage);
	}
	}

