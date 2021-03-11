/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;


import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class StudentController {
    private ArrayList<Student> students;
    private StudentView view;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    public StudentController(StudentView view) {
        this.view = view;
    }
    

    public StudentController(ArrayList<Student> students) {
        this.students = students;
    }
    
    
    
//    public void nhap_du_lieu_sinh_vien(StudentView view){
//        this.student = view.them_du_lieu_sinh_vien();
//    }
    
    public void nhap_du_lieu_sinh_vien(){
        Student student = this.view.them_du_lieu_sinh_vien();
        student.save_student_to_db();
    }
   
    
    public void nhap_danh_sach_sinh_vien(){
        this.students = this.view.nhap_du_lieu_nhieu_sinh_vien();
        for(Student sv: students){
            sv.save_student_to_db();
        }
    }
    
     
    public void hien_thi_danh_sach_sinh_vien(){
        //Lay tu csdl ra
        this.students = new Student().lay_danh_sach_sinh_vien();
//      this.view.hien_thi_danh_sach_sinh_vien(this.students);
    }
    

    private ArrayList<Student> tim_sv_theo_sdt(ArrayList<Student> students, String sdt){
        ArrayList<Student> result = new ArrayList<>(); //empty =khong tim thay
     
        for(Student sv: students){
            if (sv.getSdt().contains(sdt)){
                result.add(sv);
            }
             
        }
        return result;
    }
     
    public void tim_kiem_sv_theo_sdt(){
        String sdt = this.view.nhap_sdt_can_tim();
        ArrayList<Student> kq = tim_sv_theo_sdt(students, sdt);
        this.view.ket_qua_tim_kiem_sdt(kq);
    }
      public void sua_tt_sv_theo_sdt(){
       String sdt = this.view.nhap_sdt_can_sua();
        ArrayList<Student> kq = tim_sv_theo_sdt(students, sdt);
         this.view.ket_qua_tim_kiem_sdt(kq);
         for (Student student : kq){
             student = this.view.nhap_tt_can_sua();
         
         student.update_current_student();
        
    }
      }

 public void xoa_tt_sv_theo_sdt(){
       String sdt = this.view.nhap_sdt_can_xoa();
        ArrayList<Student> kq = tim_sv_theo_sdt(students, sdt);
         for(Student sv: kq){
            sv.delete_current_student();
        }
         
        
    }
}


