public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient newest=new Patient(id,name,age,bloodgroup,null,dh);
        if(dh.next==dh){
            dh.next=newest;
            dh.prev=newest;
            newest.next=dh;
            newest.prev=dh;
        }
        else{
            Patient temp=dh.next;
            dh.next=newest;
            newest.next=temp;
            temp.prev=newest;
            newest.prev=dh;

        }

    }

    public void servePatient() {
        if(!canDoctorGoHome()){
            Patient temp=dh.prev;
            System.out.println(temp.name+ " is served");
            Patient temp1=temp.prev;
            temp.next=null;
            temp.prev=null;
            temp1.next=dh;
            dh.prev=temp1;
        }
        else {
            System.out.println("No patients needs to be served");
        }
        
    }

    public void showAllPatient() {
        Patient current=dh.prev;
        if(dh.next==dh) System.out.println("No patients need to serve");
        while(current!=dh) {
            System.out.println(current.id);
            current = current.prev;
        }

    }

    public boolean canDoctorGoHome() {
        return dh.next == dh;
    }

    public void cancelAll() {
        dh.next=dh;
        dh.prev=dh;

    }


    public void reverseTheLine() {
        Patient current=dh.next;
        while(current!=dh) {
            Patient temp = current.next;
            Patient temp1 = current.prev;
            current.prev = temp;
            current.next = temp1;
            current = current.prev;
        }
        Patient temp=dh.next;
        dh.next=dh.prev;
        dh.prev=temp;
    }

}