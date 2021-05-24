
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

    void deleteleById(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập Id cần xóa!");
        String id =scanner.nextLine();
        if(findById(id)==null){
            System.out.println("Mã lày ko có");
        } else
        studentMap.remove(id);
    }

    Student findById(String id){
        Set<String> keySet=studentMap.keySet();
        for(String key:keySet){
            if(key.equals(id)){
                return studentMap.get(id);
            }
        }
        return null;
    }
    void sortById(){
        Set<Map.Entry<String,Student>>entries=studentMap.entrySet();
        List<Map.Entry<String,Student>>entryList=new ArrayList<>(entries);
            Collections.sort(entryList, new Comparator<Map.Entry<String, Student>>() {
                @Override
                public int compare(Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) {
                    return o1.getValue().getId().compareTo(o2.getValue().getId());
                }
            });
            LinkedHashMap<String,Student>sortStudentMap=new LinkedHashMap<>(entryList.size());
            for (Map.Entry<String,Student> entry:entryList){
                sortStudentMap.put(entry.getKey(),entry.getValue());
            }
            studentMap=sortStudentMap;
    }

//    void sort(){
//        ArrayList<Student> listStudent=new ArrayList<>(studentMap.values());
//        Collections.sort(listStudent, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//            studentMap=new HashMap<>();
//        for (int i = 0; i < listStudent.size() ; i++) {
//            studentMap.put(listStudent.get(i).getId(),listStudent.get(i));
//        }
//    }

     Student creatStudent() {
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
            System.out.println("Nhập id:");
            String id=scanner.nextLine();
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
                    deleteleById();
                    break;
                case 4:
                    System.out.println("Nhâp id cần tìm kiếm: ");
                    findById(scanner.nextLine());
                    break;
                case 5:
                    sortById();
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
