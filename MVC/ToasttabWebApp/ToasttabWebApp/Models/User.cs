using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace ToasttabWebApp.Models
{
    public class User
    {
        [DisplayName("Enter Username:")]
        public string Username { get; set; }
        [DisplayName("Enter Password:")]
        public string Password { get; set; }

        public User(string username, string passwd) { 
            Username = username;
            Password = passwd;
        }
    }
}
