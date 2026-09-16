package v5;

public class IOFile implements Saving {

    private void saveToFile( double result) {
        String filename = "result.txt";
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            writer.write("Kết quả: " + result);
            System.out.println("Kết quả đã được lưu vào tệp: " + filename);
        } catch (java.io.IOException e) {
            System.out.println("Lỗi khi lưu kết quả vào tệp: " + e.getMessage());
        }
    }

    @Override
    public void save(double result) {
        saveToFile(result);
    }

}
