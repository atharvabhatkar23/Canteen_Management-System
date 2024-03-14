import React from 'react'
import { useState } from "react";
import { ProSidebar, Menu, MenuItem } from "react-pro-sidebar";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import { Link } from "react-router-dom";
import "react-pro-sidebar/dist/css/styles.css";
import { tokens } from "../../../theme";
import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import PeopleIcon from '@mui/icons-material/People';
import PersonAddIcon from '@mui/icons-material/PersonAdd';
import RestaurantMenuIcon from '@mui/icons-material/RestaurantMenu';
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import PendingActionsIcon from '@mui/icons-material/PendingActions';
import TaskIcon from '@mui/icons-material/Task';
import LogoutIcon from '@mui/icons-material/Logout';
import { useNavigate } from 'react-router-dom';
//Styling for each item in menu sidebar
const Item = ({ title, to, icon, selected, setSelected }) => {
    const theme = useTheme();
    const colors = tokens(theme.palette.mode);
    return (
      <MenuItem
        active={selected === title}
        style={{
          color: colors.grey[100],
        }}
        onClick={() => setSelected(title)}
        icon={icon}
      >
        <Typography variant="h5">{title}</Typography>
        <Link to={to} />
      </MenuItem>
    );
  };

export default function SideBar() {
  const logoutHandle = () => {
    console.log("Removing username from localStorage...");
    localStorage.removeItem("username");
    console.log("Username removed.");
    navigate("/");
  }
  // State hooks for handling the currently selected page and opening/closing of the sidebar
    const navigate = useNavigate();
    const theme = useTheme();
    const colors = tokens(theme.palette.mode);
    const [isCollapsed, setIsCollapsed] = useState(false); //For collapsed/open sidebar
    const [selected, setSelected] = useState("Dashboard"); //For which page to display
    return (
      //Overwriting some css of react-sidebar-pro
      <Box
        sx={{
          "& .pro-sidebar-inner": {
            background: `${colors.primary[400]} !important`,  
          },
          "& .pro-icon-wrapper": {
            backgroundColor: "transparent !important",
          },
          "& .pro-inner-item": {
            padding: "5px 35px 5px 20px !important",
          },
          "& .pro-inner-item:hover": {
            color: "#868dfb !important",
          },
          "& .pro-menu-item.active": {
            color: "#6870fa !important",
          },
        }}
      >
        <ProSidebar collapsed={isCollapsed}>
          <Menu iconShape="square">
            {/* LOGO AND MENU ICON */}
            <MenuItem
              onClick={() => setIsCollapsed(!isCollapsed)}
              icon={isCollapsed ? <MenuOutlinedIcon /> : undefined}
              style={{
                margin: "10px 0 20px 0",
                color: colors.grey[100],
              }}
            >
              {!isCollapsed && (
                <Box
                  display="flex"
                  justifyContent="space-between"
                  alignItems="center"
                  ml="15px"
                >
                  <Typography variant="h3" color={colors.grey[100]}>
                  Admin
                  </Typography>
                  <IconButton onClick={() => setIsCollapsed(!isCollapsed)}>
                    <MenuOutlinedIcon />
                  </IconButton>
                </Box>
              )}
            </MenuItem>
            <Box paddingLeft={isCollapsed ? undefined : "10%"}>
            <Item
                title="Dashboard"
                to="/admin/dashboard"
                icon={<HomeOutlinedIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <br/>
              <Typography
                variant="h6"
                color={colors.grey[300]}
                sx={{ m: "15px 0 5px 20px" }}
              >
                Student
              </Typography>
              <Item
                title="Students"
                to="/admin/students"
                icon={<PeopleIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <Item
                title="Add Student"
                to="/admin/students/add"
                icon={<PersonAddIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <br/>
              <Typography
                variant="h6"
                color={colors.grey[300]}
                sx={{ m: "15px 0 5px 20px" }}
              >
                Menu
              </Typography>
              <Item
                title="Menu"
                to="/admin/menu/"
                icon={<RestaurantMenuIcon />}
                selected={selected}
                setSelected={setSelected}
              />
               <Typography
                variant="h6"
                color={colors.grey[300]}
                sx={{ m: "15px 0 5px 20px" }}
              >
                Orders
              </Typography>
              <Item
                title="Pending Orders"
                to="/admin/orders/pending"
                icon={<PendingActionsIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <Item
                title="Completed Orders"
                to="/admin/orders/completed"
                icon={<TaskIcon />}
                selected={selected}
                setSelected={setSelected}
              />
              <br/>
              <br/>
              <br/>
              <div onClick={logoutHandle}>
              <Item
                title="Logout"
                
                icon={<LogoutIcon />}
                onClick={logoutHandle}
                selected={selected}
                setSelected={setSelected}
              />
              </div>
            </Box>
          </Menu>
        </ProSidebar>
      </Box>
    );
}
