package top.sl.tmpp.purchase.entity;

/**
 * @author ShuLu
 * @date 2019/6/17 17:11
 */
public class Upload {
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String mime;
    /**
     * 扩展名
     */
    private String extensionName;
    /**
     * 文件大小(bytes)
     */
    private long size;

    public Upload() {
    }

    public Upload(String fileName, String mime, String extensionName, long size) {
        this.fileName = fileName;
        this.mime = mime;
        this.extensionName = extensionName;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
