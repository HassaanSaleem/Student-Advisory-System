-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2018 at 06:46 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `BILLID` int(11) NOT NULL,
  `AMOUNT` double DEFAULT NULL,
  `PATIENT_PTID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bill_pres`
--

CREATE TABLE `bill_pres` (
  `BILL_BILLID` int(11) NOT NULL,
  `PRESCRIPTION_PRESID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `consists_of`
--

CREATE TABLE `consists_of` (
  `PRESCRIPTION_PRESID` int(11) NOT NULL,
  `MEDICINE_MEDID` int(11) NOT NULL,
  `QUANTITY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deptt`
--

CREATE TABLE `deptt` (
  `DEPTID` int(11) NOT NULL,
  `DEPTNAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `DOCID` int(11) NOT NULL,
  `DOCNAME` varchar(50) DEFAULT NULL,
  `DEPT_DEPTID` int(11) NOT NULL,
  `SAL` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `domestic_staff`
--

CREATE TABLE `domestic_staff` (
  `DSID` int(11) NOT NULL,
  `DSNAME` varchar(50) DEFAULT NULL,
  `DEPT_DEPTID` int(11) NOT NULL,
  `SAL` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `has`
--

CREATE TABLE `has` (
  `PHARMACY_PHARID` int(11) NOT NULL,
  `MEDICINE_MEDID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `HID` int(11) NOT NULL,
  `HNAME` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `MEDID` int(11) NOT NULL,
  `MEDNAME` varchar(50) DEFAULT NULL,
  `PRODUCER` varchar(50) DEFAULT NULL,
  `PRICE` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

CREATE TABLE `nurse` (
  `NURSEID` int(11) NOT NULL,
  `NURNAME` varchar(50) DEFAULT NULL,
  `DEPT_DEPTID` int(11) NOT NULL,
  `SAL` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `PTID` int(11) NOT NULL,
  `PTNAME` varchar(50) DEFAULT NULL,
  `HISTORY` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

CREATE TABLE `pharmacy` (
  `PHARID` int(11) NOT NULL,
  `PHARNAME` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `PRESID` int(11) NOT NULL,
  `PHARMACY_PHARID` int(11) NOT NULL,
  `DOCTOR_DOCID` int(11) NOT NULL,
  `COST` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `research`
--

CREATE TABLE `research` (
  `RESID` int(11) NOT NULL,
  `RESNAME` varchar(50) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `DEPT_DEPTID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `researches_on`
--

CREATE TABLE `researches_on` (
  `NO_OF_HRS` int(11) DEFAULT NULL,
  `DOCTOR_DOCID` int(11) NOT NULL,
  `RESEARCH_RESID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `treat`
--

CREATE TABLE `treat` (
  `PATIENT_PTID` int(11) NOT NULL,
  `DOCTOR_DOCID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BILLID`),
  ADD KEY `BILL_PATIENT_FK` (`PATIENT_PTID`);

--
-- Indexes for table `bill_pres`
--
ALTER TABLE `bill_pres`
  ADD PRIMARY KEY (`BILL_BILLID`,`PRESCRIPTION_PRESID`),
  ADD KEY `BILL_PRES_PRESCRIPTION_FK` (`PRESCRIPTION_PRESID`);

--
-- Indexes for table `consists_of`
--
ALTER TABLE `consists_of`
  ADD PRIMARY KEY (`PRESCRIPTION_PRESID`,`MEDICINE_MEDID`),
  ADD KEY `COSISTS_OF_MEDICINE_FK` (`MEDICINE_MEDID`);

--
-- Indexes for table `deptt`
--
ALTER TABLE `deptt`
  ADD PRIMARY KEY (`DEPTID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`DOCID`),
  ADD KEY `DOCTOR_DEPT_FK` (`DEPT_DEPTID`);

--
-- Indexes for table `domestic_staff`
--
ALTER TABLE `domestic_staff`
  ADD PRIMARY KEY (`DSID`),
  ADD KEY `DOMESTIC_STAFF_DEPT_FK` (`DEPT_DEPTID`);

--
-- Indexes for table `has`
--
ALTER TABLE `has`
  ADD PRIMARY KEY (`PHARMACY_PHARID`,`MEDICINE_MEDID`),
  ADD KEY `HAS_MEDICINE_FK` (`MEDICINE_MEDID`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`HID`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`MEDID`);

--
-- Indexes for table `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`NURSEID`),
  ADD KEY `NURSE_DEPT_FK` (`DEPT_DEPTID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PTID`);

--
-- Indexes for table `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`PHARID`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`PRESID`),
  ADD KEY `PRESCRIPTION_DOCTOR_FK` (`DOCTOR_DOCID`),
  ADD KEY `PRESCRIPTION_PHARMACY_FK` (`PHARMACY_PHARID`);

--
-- Indexes for table `research`
--
ALTER TABLE `research`
  ADD PRIMARY KEY (`RESID`),
  ADD KEY `RESEARCH_DEPT_FK` (`DEPT_DEPTID`);

--
-- Indexes for table `researches_on`
--
ALTER TABLE `researches_on`
  ADD PRIMARY KEY (`DOCTOR_DOCID`,`RESEARCH_RESID`),
  ADD KEY `RESEARCHES_ON_RESEARCH_FK` (`RESEARCH_RESID`);

--
-- Indexes for table `treat`
--
ALTER TABLE `treat`
  ADD PRIMARY KEY (`PATIENT_PTID`,`DOCTOR_DOCID`),
  ADD KEY `TREAT_DOCTOR_FK` (`DOCTOR_DOCID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `BILL_PATIENT_FK` FOREIGN KEY (`PATIENT_PTID`) REFERENCES `patient` (`PTID`) on update CASCADE;

--
-- Constraints for table `bill_pres`
--
ALTER TABLE `bill_pres`
  ADD CONSTRAINT `BILL_PRES_BILL_FK` FOREIGN KEY (`BILL_BILLID`) REFERENCES `bill` (`BILLID`) on update CASCADE,
  ADD CONSTRAINT `BILL_PRES_PRESCRIPTION_FK` FOREIGN KEY (`PRESCRIPTION_PRESID`) REFERENCES `prescription` (`PRESID`)on update CASCADE;

--
-- Constraints for table `consists_of`
--
ALTER TABLE `consists_of`
  ADD CONSTRAINT `COSISTS_OF_MEDICINE_FK` FOREIGN KEY (`MEDICINE_MEDID`) REFERENCES `medicine` (`MEDID`) on update CASCADE,
  ADD CONSTRAINT `COSISTS_OF_PRESCRIPTION_FK` FOREIGN KEY (`PRESCRIPTION_PRESID`) REFERENCES `prescription` (`PRESID`)on update CASCADE;

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `DOCTOR_DEPT_FK` FOREIGN KEY (`DEPT_DEPTID`) REFERENCES `deptt` (`DEPTID`) on update CASCADE;

--
-- Constraints for table `domestic_staff`
--
ALTER TABLE `domestic_staff`
  ADD CONSTRAINT `DOMESTIC_STAFF_DEPT_FK` FOREIGN KEY (`DEPT_DEPTID`) REFERENCES `deptt` (`DEPTID`)on update CASCADE;

--
-- Constraints for table `has`
--
ALTER TABLE `has`
  ADD CONSTRAINT `HAS_MEDICINE_FK` FOREIGN KEY (`MEDICINE_MEDID`) REFERENCES `medicine` (`MEDID`) on update CASCADE,
  ADD CONSTRAINT `HAS_PHARMACY_FK` FOREIGN KEY (`PHARMACY_PHARID`) REFERENCES `pharmacy` (`PHARID`)on update CASCADE;

--
-- Constraints for table `nurse`
--
ALTER TABLE `nurse`
  ADD CONSTRAINT `NURSE_DEPT_FK` FOREIGN KEY (`DEPT_DEPTID`) REFERENCES `deptt` (`DEPTID`)on update CASCADE;

--
-- Constraints for table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `PRESCRIPTION_DOCTOR_FK` FOREIGN KEY (`DOCTOR_DOCID`) REFERENCES `doctor` (`DOCID`) on update CASCADE,
  ADD CONSTRAINT `PRESCRIPTION_PHARMACY_FK` FOREIGN KEY (`PHARMACY_PHARID`) REFERENCES `pharmacy` (`PHARID`)on update CASCADE;

--
-- Constraints for table `research`
--
ALTER TABLE `research`
  ADD CONSTRAINT `RESEARCH_DEPT_FK` FOREIGN KEY (`DEPT_DEPTID`) REFERENCES `deptt` (`DEPTID`)on update CASCADE ;

--
-- Constraints for table `researches_on`
--
ALTER TABLE `researches_on`
  ADD CONSTRAINT `RESEARCHES_ON_DOCTOR_FK` FOREIGN KEY (`DOCTOR_DOCID`) REFERENCES `doctor` (`DOCID`)on update CASCADE,
  ADD CONSTRAINT `RESEARCHES_ON_RESEARCH_FK` FOREIGN KEY (`RESEARCH_RESID`) REFERENCES `research` (`RESID`) on update CASCADE;

--
-- Constraints for table `treat`
--
ALTER TABLE `treat`
  ADD CONSTRAINT `TREAT_DOCTOR_FK` FOREIGN KEY (`DOCTOR_DOCID`) REFERENCES `doctor` (`DOCID`) on update CASCADE,
  ADD CONSTRAINT `TREAT_PATIENT_FK` FOREIGN KEY (`PATIENT_PTID`) REFERENCES `patient` (`PTID`);
COMMIT on update CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
