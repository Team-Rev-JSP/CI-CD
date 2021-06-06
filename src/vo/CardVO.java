package vo;

public class CardVO {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private String address;
    private String fax;
    private String url;
    private String company;
    private String photo_path;
    private String uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CardVO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", position='" + position + '\'' +
            ", address='" + address + '\'' +
            ", fax='" + fax + '\'' +
            ", url='" + url + '\'' +
            ", company='" + company + '\'' +
            ", photo_path='" + photo_path + '\'' +
            ", uid='" + uid + '\'' +
            '}';
    }
}
