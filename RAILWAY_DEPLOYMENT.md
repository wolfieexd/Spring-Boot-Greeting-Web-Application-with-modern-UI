# 🚀 Railway Deployment Guide

## Quick Deploy to Railway

### Prerequisites
- GitHub account with this repository
- Railway account (sign up at https://railway.app)

### Deployment Steps

1. **Go to Railway Dashboard**
   - Visit: https://railway.app
   - Click "Start a New Project"

2. **Deploy from GitHub**
   - Select "Deploy from GitHub repo"
   - Choose: `wolfieexd/Spring-Boot-Greeting-Web-Application-with-modern-UI`
   - **Important**: When prompted, enter a simple service name like: `greeting-webapp` or `greeting-api`
     (Avoid long names or special characters - Railway requires short, simple names)
   - Railway will automatically detect the Spring Boot project

3. **Configuration (Automatic)**
   - Railway will use `nixpacks.toml` for build configuration
   - Java 21 will be installed automatically
   - Maven will build the project
   - The app will start on the PORT provided by Railway

4. **Environment Variables** (Optional)
   Railway automatically provides:
   - `PORT` - The port your app should listen on (already configured)
   
   No additional configuration needed!

5. **Access Your App**
   - Railway will provide a public URL
   - Your app will be live at: `https://your-app-name.up.railway.app`

### Build Process
Railway will:
1. Install Java 21
2. Run `mvn clean package -DskipTests`
3. Start the app with `java -jar target/greeting-app-1.0.0.jar`

### Monitoring
- View logs in Railway dashboard
- Monitor deployments and restarts
- Set up custom domains if needed

### Cost
- Railway offers 500 hours/month free tier
- $5/month after free tier usage
- No credit card required for free tier

---

## What's Configured

✅ Spring Boot 3.4.0 (latest version)
✅ Java 21 runtime
✅ Dynamic port binding (`PORT` environment variable)
✅ Railway configuration files (`railway.json`, `nixpacks.toml`)
✅ Automatic restart on failure
✅ Maven build configuration

## Troubleshooting

**Build Fails:**
- Check Railway logs for errors
- Ensure Java 21 is being used

**App Doesn't Start:**
- Verify PORT environment variable is set
- Check application logs in Railway dashboard

**Changes Not Deploying:**
- Push changes to GitHub main branch
- Railway auto-deploys on push

---

## Next Steps

After deployment:
1. Test all endpoints
2. Set up custom domain (optional)
3. Configure monitoring/alerts
4. Set up production environment variables if needed

**Live URL:** Will be provided by Railway after deployment

🎉 Your app is production-ready!
