
import java.util.*;


public  class ManageStudent {
    Scanner scanner =new Scanner(System.in);
    HashMap<String,Student> studentMap=null;
    public ManageStudent(){
        studentMap=new HashMap<>();
    }

    public void addStudent(Student student){
        studentMap.put(student.getId(),student);
    }


     void display() {
         Set<String> keySet=studentMap.keySet();
            for (String key : keySet) {
                System.out.println(key + " - " + studentMap.get(key));
            }
    }
//    Student findByName(String name){
//        Set<String> keySet=studentMap.keySet();
//        for (String key : keySet) {
//            if(studentMap.get(key).getName().equals(name)){
//                return studentMap.get(key);
//            }
//        }
//                return null;
//    }
    Student findById(String id){
        Set<String> keySet=studentMap.keySet();
        for(String key:keySet){
            if(key.equals(id)){
                return studentMap.get(id);
            }
        }
        return null;
    }
    void deleteleById(String id){
        studentMap.remove(id);
    }
    void sort(){
        ArrayList<Student> listStudent=new ArrayList<>(studentMap.values());
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
            studentMap=new HashMap<>();
        for (int i = 0; i < listStudent.size() ; i++) {
            studentMap.put(listStudent.get(i).getId(),listStudent.get(i));
        }
    }
//    void deleteByName(String name){
//        studentMap.remove(findByName(name).getId());
//    }
//    void editStudent(String id){
//
//    }

     Student creatStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Nhập tên sinh viên: ");
        student.setName(scanner.nextLine());
        System.out.println("Nhập tuổi sinh viên: ");
        student.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập giới tính sinh viên(Nam: bấm 1; Nữ bấm 2) : ");
        student.setGender(enterGender());
        System.out.println("Nhập địa chỉ: ");
        student.setAddress(scanner.nextLine());
        return student;
    }
    String enterGender() {
        String gender;
        Scanner scanner=new Scanner(System.in);
        while (true){
            int scanGender= scanner.nextInt();
            if(scanGender==1){
                gender="Nam";
                break;
            } else if(scanGender==2){
                gender="Nữ";
                break;
            } else
                System.out.println("Nhập 1 hoặc 2 !");
        }
        return gender;
    }
        Student update() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập id:");
            String id=scanner.nextLine();
//            Set<String> keySet = studentMap.keySet();
//            for (String key : keySet) {
                if (findById(id)!=null) {
                    System.out.println("Nhập tên:");
                    findById(id).setName(scanner.nextLine());
                    System.out.println("Nhập tuổi: ");
                    findById(id).setAge(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Nhập giới tính: ");
                    findById(id).setGender(enterGender());
                    System.out.println("Nhập đia chỉ:");
                    findById(id).setAddress(scanner.nextLine());
                }else return null;

            return findById(id);
        }


    void start(){
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
                menu();
            System.out.println("Nhập lựa chọn: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addStudent(creatStudent());
                    break;
                case 2:
                    if(update()==null){
                        System.out.println("Không tìm thấy thanh niên");
                    }else  update();
                    break;
                case 3:
                    System.out.println("Nhập id cần xóa");
                    deleteleById(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Nhâp id cần tìm kiếm: ");
                    findById(scanner.nextLine());
                    break;
                case 5:
                    sort();
                    break;
                case 6:
                    display();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice<=16&&choice>=0);
    }
    void menu(){
        System.out.println("QUẢN LÝ SINH VIÊN");
        System.out.printf("%-12s%-12s%s\n","1.Thêm","2.Sửa","3.Xóa");
        System.out.printf("%-12s%-12s%s\n","4.Tìm kiếm","5.Sắp xếp","6.Hiển thị");
    }

}
