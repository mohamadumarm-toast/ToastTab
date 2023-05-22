using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using MyApp.Models;
namespace MyApp.Controllers
{
    public class LoginController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(string username, string password)
        {
            DbSqlServer sqlServer = new();
            if (sqlServer.ConnectAndValidateWithDB(username, password) == 1)
            {
                ViewBag.username = username;
                return View("LoginSuccess");
            }
            else
            {
                ViewBag.ErrorMessage = "Please enter a valid username and password.";
                return View("Index");
            }
            
        }
    }
}

