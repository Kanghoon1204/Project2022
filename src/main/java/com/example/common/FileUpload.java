package com.example.common;

import com.example.bean.BoardVO;
import com.example.bean.MessageVO;
import com.example.dao.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public BoardVO uploadPhoto(HttpServletRequest request){
        String filename ="";
        int sizeLimit = 15 * 1024 * 1024;
        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdir();

        BoardVO one = null;
        MultipartRequest multipartRequest = null;
        try{
            multipartRequest = new MultipartRequest(request,realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            one = new BoardVO();
            String sid = multipartRequest.getParameter("id");
            if (sid !=null &&!sid.equals("")) one.setSeq(Integer.parseInt(sid));
            one.setCategory(multipartRequest.getParameter("category"));
            one.setWriter(multipartRequest.getParameter("writer"));
            one.setTitle(multipartRequest.getParameter("title"));
            one.setContent(multipartRequest.getParameter("content"));
            one.setAnonymous(Boolean.parseBoolean(multipartRequest.getParameter("anonymous")));
            if (sid !=null &&!sid.equals(""))
            {
                BoardDAO dao = new BoardDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(sid));
                if (filename !=null && oldfilename !=null)
                    FileUpload.deleteFile(request, oldfilename);
                else if (filename == null && oldfilename !=null)
                    filename = oldfilename;
            }
            one.setPhoto(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }
    public BoardVO editPhoto(HttpServletRequest request){
        String filename ="";
        int sizeLimit = 15 * 1024 * 1024;
        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdir();

        BoardVO one = null;
        MultipartRequest multipartRequest;
        try{
            multipartRequest = new MultipartRequest(request,realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            System.out.println("check");
            System.out.println(filename);
            one = new BoardVO();
            String sid = multipartRequest.getParameter("id");
            if (sid !=null && sid.equals("")) one.setSeq(Integer.parseInt(sid));
            one.setCategory(multipartRequest.getParameter("category"));
            one.setWriter(multipartRequest.getParameter("writer"));
            one.setTitle(multipartRequest.getParameter("title"));
            one.setContent(multipartRequest.getParameter("content"));
            one.setSeq(Integer.parseInt(multipartRequest.getParameter("seq")));
            one.setAnonymous(Boolean.parseBoolean(multipartRequest.getParameter("anonymous")));
            //one.setPhoto(multipartRequest.getParameter("photo"));

            if (sid !=null && sid.equals(""))
            {
                BoardDAO dao = new BoardDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(sid));
                if (filename !=null && oldfilename !=null)
                    FileUpload.deleteFile(request, oldfilename);
                else if (filename == null && oldfilename !=null)
                    filename = oldfilename;
            }
            one.setPhoto(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  one;
    }

    public static void deleteFile(HttpServletRequest request, String filename) {
        String filePath = request.getServletContext().getRealPath("upload");
        File f = new File(filePath + "/" + filename);
        if (f.exists()) f.delete();
    }

    public MessageVO uploadMessage(HttpServletRequest request){
        String filename ="";
        int sizeLimit = 15 * 1024 * 1024;
        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdir();

        MessageVO one = null;
        MultipartRequest multipartRequest = null;
        try{
            multipartRequest = new MultipartRequest(request,realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            one = new MessageVO();
            String sid = multipartRequest.getParameter("id");
            if (sid !=null &&!sid.equals("")) one.setSeq_message(Integer.parseInt(sid));
            one.setContent_message(multipartRequest.getParameter("content_message"));
            one.setCnt_message(Integer.parseInt(multipartRequest.getParameter("cnt_message")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }
}
