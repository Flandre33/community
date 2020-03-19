package life.majiang.community.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import life.majiang.community.parm.GiteeImgBedConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {

    @RequestMapping("/file/upload")
    @ResponseBody
    public Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        //保存
        try {
            File imageFolder= new File(request.getServletContext().getRealPath("images/upload"));
            File targetFile = new File(imageFolder,file.getOriginalFilename());
            if(!targetFile.getParentFile().exists())
                targetFile.getParentFile().mkdirs();
            file.transferTo(targetFile);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url","http://flandre33.gitee.io/community/src/main/resources/static/images/" + file.getOriginalFilename());
            // 转存到gitee
            resultMap.put("access_token", GiteeImgBedConstant.ACCESS_TOKEN);
            resultMap.put("message", GiteeImgBedConstant.CREATE_REPOS_MESSAGE);
            resultMap.put("content", Base64.encode(file.getOriginalFilename().getBytes()));
            String targetDir = GiteeImgBedConstant.IMG_FILE_DEST_PATH + file.getOriginalFilename();
            String requestUrl = String.format(GiteeImgBedConstant.CREATE_REPOS_URL, GiteeImgBedConstant.OWNER,
                    GiteeImgBedConstant.REPO_NAME, targetDir);
            String resultJson = HttpUtil.post(requestUrl, resultMap);
            JSONObject jsonObject = JSONUtil.parseObj(resultJson);
            String resultImgUrl = GiteeImgBedConstant.GITPAGE_REQUEST_URL + targetDir;
            resultMap.put("resultImgUrl", resultImgUrl);
            System.out.println(resultMap);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }

        return resultMap;
    }
}
