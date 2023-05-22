using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using System.Diagnostics;
using ToasttabWebApp.Models;
using Microsoft.AspNetCore.Http;
namespace ToasttabWebApp.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        private static List<User> users = new List<User>()
        {
            new User("admin", "admin"),
            new User("Toast", "Toast@1234")
        };

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }
        [HttpGet]
        public IActionResult Index()
        {
            return View("Index");
        }
        [HttpGet]
        public IActionResult Signup()
        {
            return View("Signup");
        }
        [HttpPost]
        public IActionResult Validate(string username, string password)
        {
            if (users.Any(u=> u.Username == username && u.Password == password ))
            {
                HttpContext.Session.SetString("user",username);
                ViewBag.data = HttpContext.Session.GetString("user");
                return View("Dashboard");
            }
            return View("Index");
        }
        [HttpPost]
        public IActionResult Create(string username, string password) {
            users.Add(new User(username, password));
            return View("Index");
        }

        public IActionResult Welcome()
        {
            if (string.IsNullOrEmpty(HttpContext.Session.GetString("user")))
            {
                ViewBag.Layout = "_Layout2";
                return View("Welcome");
            }
            ViewBag.Layout = "_Layout";
            return View("Welcome");
        }

        public IActionResult Logout()
        {
            HttpContext.Session.Clear();
            return RedirectToAction("Welcome");
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}