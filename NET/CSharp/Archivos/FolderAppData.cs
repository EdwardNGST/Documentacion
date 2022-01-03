The first two passes are straightforward

// The folder for the roaming current user 
string folder = Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData);

// Combine the base folder with your specific folder....
string specificFolder = Path.Combine(folder, "YourSpecificFolder");

// CreateDirectory will check if every folder in path exists and, if not, create them.
// If all folders exist then CreateDirectory will do nothing.
Directory.CreateDirectory(specificFolder);
In the last pass is not clear where you have the file to copy.
However, supposing that you have a file called

string file = @"C:\program files\myapp\file.txt";
File.Copy(file, Path.Combine(specificFolder, Path.GetFileName(file));