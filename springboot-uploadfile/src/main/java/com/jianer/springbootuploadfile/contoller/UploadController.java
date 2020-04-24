package com.jianer.springbootuploadfile.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author 杨兴健
 * @Date 2020/4/10 12:25
 */
@Controller
public class UploadController {

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message","请选择文件，重新上传！");
            return "uploadStatus";
        }
        String filename = file.getOriginalFilename();
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("e:/upload/" + filename)))

        ) {
            InputStream is = file.getInputStream();
            byte[] bytes=  new byte[1024 *8];
            int len;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message","上传失败，请重新上传！");
            return "uploadStatus";
        }

        model.addAttribute("message","上传成功！");
        return "uploadStatus";

    }
}
