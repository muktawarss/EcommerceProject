package helperMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

	private List<String> fileList;
	private static String OUTPUT_ZIP_FILE;
	private static String SOURCE_FOLDER;

	@SuppressWarnings("static-access")
	public ZipUtil(String srcFolder, String outputZipFile) throws IOException {
		fileList = new ArrayList<String>();
		this.SOURCE_FOLDER = srcFolder;
		this.OUTPUT_ZIP_FILE = outputZipFile;
		generateFileList(new File(SOURCE_FOLDER));
		zipIt(OUTPUT_ZIP_FILE);
	}

	/**
	 * Zip it
	 *
	 * @param zipFile
	 *            output ZIP file location
	 */
	public void zipIt(String zipFile) {
		byte[] buffer = new byte[1024];
		String source = new File(SOURCE_FOLDER).getName();
		FileOutputStream fos;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);

			FileInputStream in = null;

			for (String file : this.fileList) {
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					in.close();
				}
			}
			zos.closeEntry();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Traverse a directory and get all files, and add the file into fileList
	 *
	 * @param node
	 *            file or directory
	 */
	public void generateFileList(File node) {
		// Add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.toString()));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}
	}

	/**
	 * Format the file path for zip
	 *
	 * @param file
	 *            file path
	 * @return Formatted file path
	 */
	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}
}