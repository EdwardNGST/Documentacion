ObservableCollection<User> users = new ObservableCollection<User>();
users.Add(new User{FirstName = "firstname-1",LastName = "lastname-1"});
users.Add(new User{FirstName = "firstname-2",LastName = "lastname-2"});
users.Add(new User{FirstName = "firstname-3",LastName = "lastname-3"});
users.Add(new User{FirstName = "firstname-4",LastName = "lastname-4"});
DataGrid.ItemsSource = users;

//Reference: https://stackoverflow.com/questions/20350886/wpf-fill-data-on-data-grid