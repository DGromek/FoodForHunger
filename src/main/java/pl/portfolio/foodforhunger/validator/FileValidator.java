package pl.portfolio.foodforhunger.validator;

import org.springframework.web.multipart.MultipartFile;

public class FileValidator {

    public static boolean isImageExtensionCorrect(MultipartFile uploadedFile) {
        String uploadedFileName = uploadedFile.getOriginalFilename();
        int indexOfDotInFileExtension = uploadedFileName.lastIndexOf('.');

        if (indexOfDotInFileExtension == -1) {
            return false;
        }

        String fileExtension = uploadedFileName.substring(indexOfDotInFileExtension);

        return ".jpg".equals(fileExtension) || ".jpeg".equals(fileExtension) || ".png".equals(fileExtension);
    }
}
