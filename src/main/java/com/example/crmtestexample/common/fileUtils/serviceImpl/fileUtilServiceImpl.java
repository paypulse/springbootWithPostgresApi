package com.example.crmtestexample.common.fileUtils.serviceImpl;

import com.example.crmtestexample.common.fileUtils.domain.fileUtilDao;
import com.example.crmtestexample.common.fileUtils.service.fileUtilService;
import com.example.crmtestexample.model.request.fileUtilRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;


@Transactional
@Service
public class fileUtilServiceImpl implements fileUtilService {

    @Autowired
    private fileUtilDao fileutilDao;


    /**
     * File Upload
     * @param
     * @return
     * */
    @Override
    public void singleFileUpload(MultipartFile file,String user ,String savePath) {
        try{

            //저장될 파일이 존재하는지 아닌지
            if(!new File(savePath).exists()){
                try{
                    new File(savePath).mkdir();
                }catch (Exception e){
                    e.getStackTrace();
                }
            }

            String filePath = savePath+"/"+ file.getOriginalFilename();
            //파일 저장
            file.transferTo(new File(filePath));

            //테이블에 파일 저장
            fileUtilRequest req = new fileUtilRequest();
            req.setFiletype("01");
            req.setFilename(file.getName());
            req.setFilepath(filePath);
            req.setFileoriname(file.getOriginalFilename());
            ///login user 정보
            req.setFileMakeUser(user);
            fileutilDao.singleFileUpload(req);

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
